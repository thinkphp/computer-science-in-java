import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    private JLabel display;
    private StringBuilder currentInput;

    public CalculatorApp() {
        currentInput = new StringBuilder();

        // Set up the frame
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set up the display
        display = new JLabel("0", SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 36));
        display.setOpaque(true);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setPreferredSize(new Dimension(400, 100));
        add(display, BorderLayout.NORTH);

        // Set up the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));

        String[] buttonLabels = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "*",
                "0", ".", "=", "/",
                "C", "←" // Added backspace button "←"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.setBackground(Color.YELLOW); // Set the background color to yellow
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "=":
                compute();
                break;
            case "C":
                clearDisplay();
                break;
            case "←": // Handle backspace action
                backspace();
                break;
            default:
                appendCharacter(command);
                break;
        }
    }

    private void appendCharacter(String character) {
        currentInput.append(character);
        updateDisplay();
    }

    private void backspace() {
        if (currentInput.length() > 0) {
            currentInput.deleteCharAt(currentInput.length() - 1);
            updateDisplay();
        }
    }

    private void compute() {
        try {
            String result = evaluateExpression(currentInput.toString());
            currentInput.setLength(0);
            currentInput.append(result);
        } catch (Exception e) {
            currentInput.setLength(0);
            currentInput.append("Error");
        }
        updateDisplay();
    }

    private void clearDisplay() {
        currentInput.setLength(0);
        updateDisplay();
    }

    private void updateDisplay() {
        display.setText(currentInput.length() == 0 ? "0" : currentInput.toString());
    }

    private String evaluateExpression(String expression) {
        try {
            return Double.toString(new ExpressionEvaluator().evaluate(expression));
        } catch (Exception e) {
            return "Error";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApp calculator = new CalculatorApp();
            calculator.setVisible(true);
        });
    }
}

// This class will parse and evaluate the mathematical expressions
class ExpressionEvaluator {
    public double evaluate(String expression) throws Exception {
        double result = 0;
        double currentNumber = 0;
        char lastOperator = '+';

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar) || currentChar == '.') {
                int dotPos = i;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    i++;
                }
                currentNumber = Double.parseDouble(expression.substring(dotPos, i));
                i--;
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                result = applyOperation(result, currentNumber, lastOperator);
                lastOperator = currentChar;
            }
        }

        // Apply the last operation to get the final result
        result = applyOperation(result, currentNumber, lastOperator);

        return result;
    }

    private double applyOperation(double result, double number, char operator) {
        switch (operator) {
            case '+':
                return result + number;
            case '-':
                return result - number;
            case '*':
                return result * number;
            case '/':
                return result / number;
            default:
                return result;
        }
    }
}
