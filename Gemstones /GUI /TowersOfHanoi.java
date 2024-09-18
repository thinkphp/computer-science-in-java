import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TowerOfHanoi extends JFrame {
    private JPanel setupPanel;
    private Canvas canvas;
    private JComboBox<String> diskSelector;
    private JButton startButton;
    private JButton solveButton;
    private int numDisks = 3;
    private List<Stack<Integer>> towers;
    private Color[] colors;
    private Integer selectedTower = null;
    private boolean isSolving = false;

    public TowerOfHanoi() {
        setTitle("Tower of Hanoi");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setupPanel = new JPanel();
        add(setupPanel, BorderLayout.NORTH);

        setupPanel.add(new JLabel("Select number of disks:"));
        diskSelector = new JComboBox<>(new String[]{"3", "4", "5", "6", "7"});
        diskSelector.setSelectedItem("3");
        setupPanel.add(diskSelector);

        startButton = new JButton("Start Game");
        setupPanel.add(startButton);

        solveButton = new JButton("Solve");
        solveButton.setEnabled(false);
        setupPanel.add(solveButton);

        canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                drawTowers(g);
            }
        };
        canvas.setPreferredSize(new Dimension(600, 400));
        add(canvas, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSolve();
            }
        });

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClick(e);
            }
        });
    }

    private void startGame() {
        if (isSolving) {
            return;
        }

        numDisks = Integer.parseInt((String) diskSelector.getSelectedItem());
        towers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            towers.add(new Stack<>());
        }

        for (int i = numDisks; i > 0; i--) {
            towers.get(0).push(i);
        }

        colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.PINK, Color.ORANGE, Color.CYAN};
        selectedTower = null;
        isSolving = false;

        drawTowers(canvas.getGraphics());
        solveButton.setEnabled(true);
    }

    private void drawTowers(Graphics g) {
        g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i = 0; i < 3; i++) {
            int x = 100 + i * 200;
            g.setColor(new Color(139, 69, 19)); // Brown color
            g.fillRect(x, 350, 40, 10); // Draw base
            g.fillRect(x + 10, 150, 20, 200); // Draw pole

            for (int j = 0; j < towers.get(i).size(); j++) {
                drawDisk(g, i, j, towers.get(i).get(j));
            }
        }
    }

    private void drawDisk(Graphics g, int tower, int position, int size) {
        int x = 120 + tower * 200;
        int y = 340 - position * 20;
        int width = size * 15;
        Color fillColor = colors[size - 1];
        Color outlineColor = (selectedTower != null && selectedTower == tower && position == towers.get(tower).size() - 1) ? Color.YELLOW : Color.BLACK;

        g.setColor(fillColor);
        g.fillRect(x - width / 2, y - 8, width, 16);
        g.setColor(outlineColor);
        g.drawRect(x - width / 2, y - 8, width, 16);
    }

    private void onClick(MouseEvent e) {
        if (isSolving) {
            return;
        }

        int x = e.getX();
        int tower = (x - 100) / 200;

        if (selectedTower == null) {
            if (!towers.get(tower).isEmpty()) {
                selectedTower = tower;
                drawTowers(canvas.getGraphics());
            }
        } else {
            if (canMove(selectedTower, tower)) {
                int disk = towers.get(selectedTower).pop();
                towers.get(tower).push(disk);
                selectedTower = null;
                drawTowers(canvas.getGraphics());

                if (checkWin()) {
                    showWinMessage();
                }
            } else {
                selectedTower = null;
                drawTowers(canvas.getGraphics());
            }
        }
    }

    private boolean canMove(int fromTower, int toTower) {
        if (towers.get(fromTower).isEmpty()) {
            return false;
        }

        if (towers.get(toTower).isEmpty() || towers.get(fromTower).peek() < towers.get(toTower).peek()) {
            return true;
        }

        return false;
    }

    private boolean checkWin() {
        return towers.get(2).size() == numDisks;
    }

    private void showWinMessage() {
        JOptionPane.showMessageDialog(this, "Congratulations! You solved the puzzle!", "Winner", JOptionPane.INFORMATION_MESSAGE);
    }

    private void startSolve() {
        if (!isSolving) {
            isSolving = true;
            solveButton.setEnabled(false);
            towers = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                towers.add(new Stack<>());
            }
            for (int i = numDisks; i > 0; i--) {
                towers.get(0).push(i);
            }
            drawTowers(canvas.getGraphics());
            SwingUtilities.invokeLater(() -> solveHanoi(numDisks, 0, 2, 1));
        }
    }

    private void solveHanoi(int n, int source, int target, int auxiliary) {
        if (n > 0) {
            solveHanoi(n - 1, source, auxiliary, target);
            moveDisk(source, target);
            solveHanoi(n - 1, auxiliary, target, source);
        }
    }

    private void moveDisk(int source, int target) {
        int disk = towers.get(source).pop();
        towers.get(target).push(disk);
        drawTowers(canvas.getGraphics());

        try {
            Thread.sleep(1000); // Pause for 1 second between moves
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (checkWin()) {
            showWinMessage();
            isSolving = false;
            solveButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TowerOfHanoi frame = new TowerOfHanoi();
            frame.setVisible(true);
        });
    }
}
