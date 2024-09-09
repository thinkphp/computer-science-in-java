import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return (completed ? "[X] " : "[ ] ") + description;
    }
}

public class ToDoListGUI extends JFrame {
    private ArrayList<Task> tasks;
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;
    private JTextField taskInput;
    private JButton addButton, completeButton, updateButton, deleteButton;

    public ToDoListGUI() {
        super("To-Do List");
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Task list
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel();
        taskInput = new JTextField(20);
        addButton = new JButton("Add");
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel();
        completeButton = new JButton("Mark Completed");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        buttonPanel.add(completeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add task
        addButton.addActionListener(e -> {
            String description = taskInput.getText().trim();
            if (!description.isEmpty()) {
                Task newTask = new Task(description);
                tasks.add(newTask);
                listModel.addElement(newTask);
                taskInput.setText("");
            }
        });

        // Mark task as completed
        completeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                Task task = tasks.get(selectedIndex);
                task.setCompleted(true);
                listModel.set(selectedIndex, task);
            }
        });

        // Update task
        updateButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                String newDescription = JOptionPane.showInputDialog(this, "Enter new task description:");
                if (newDescription != null && !newDescription.trim().isEmpty()) {
                    Task task = tasks.get(selectedIndex);
                    task.setDescription(newDescription.trim());
                    listModel.set(selectedIndex, task);
                }
            }
        });

        // Delete task
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                tasks.remove(selectedIndex);
                listModel.remove(selectedIndex);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ToDoListGUI gui = new ToDoListGUI();
            gui.setVisible(true);
        });
    }
}
