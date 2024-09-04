import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bubble {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Bubble Sort Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a text field for input
        JTextField inputField = new JTextField(20);

        // Create a button to trigger sorting
        JButton sortButton = new JButton("Sort");

        // Create a text field to show the sorted output
        JTextField outputField = new JTextField(20);
        outputField.setEditable(false); // Make the output field read-only

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter numbers:"));
        panel.add(inputField);
        panel.add(sortButton);
        panel.add(new JLabel("Sorted numbers:"));
        panel.add(outputField);

        // Add the panel to the frame
        frame.add(panel);

        // Add action listener to the button
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input text
                String inputText = inputField.getText();

                // Parse the input into an array of integers
                String[] numberStrings = inputText.split("[ ,]+");
                int[] numbers = new int[numberStrings.length];

                try {
                    for (int i = 0; i < numberStrings.length; i++) {
                        numbers[i] = Integer.parseInt(numberStrings[i]);
                    }

                    // Sort the array using bubble sort
                    bubbleSort(numbers);

                    // Convert the sorted array back to a string
                    StringBuilder sortedText = new StringBuilder();
                    for (int num : numbers) {
                        sortedText.append(num).append(" ");
                    }

                    // Set the sorted numbers in the output field
                    outputField.setText(sortedText.toString().trim());
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers separated by spaces or commas.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set the frame to be visible
        frame.setVisible(true);
    }

    // Bubble sort algorithm
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
