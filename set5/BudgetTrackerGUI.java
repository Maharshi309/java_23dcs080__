import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BudgetTrackerGUI extends JFrame {
    private double balance;
    private ArrayList<String> transactionHistory;

    private JLabel balanceLabel;
    private JTextArea transactionArea;
    private JTextField incomeField;
    private JTextField expenseField;
    private JTextField reasonField;

    public BudgetTrackerGUI() {
        balance = 0.0;
        transactionHistory = new ArrayList<>();

        // Set up the JFrame
        setTitle("Budget Tracker");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the balance label
        balanceLabel = new JLabel("Current Balance: $0.0");
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(balanceLabel, BorderLayout.NORTH);

        // Create the transaction history area
        transactionArea = new JTextArea(10, 30);
        transactionArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transactionArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));  // Use 3 rows, 2 columns

        // Income input
        inputPanel.add(new JLabel("Income Amount: "));
        incomeField = new JTextField();
        inputPanel.add(incomeField);

        // Expense input
        inputPanel.add(new JLabel("Expense Amount: "));
        expenseField = new JTextField();
        inputPanel.add(expenseField);

        // Reason input
        inputPanel.add(new JLabel("Reason for Expense: "));
        reasonField = new JTextField();
        inputPanel.add(reasonField);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        JButton addIncomeButton = new JButton("Add Income");
        JButton addExpenseButton = new JButton("Add Expense");
        JButton showHistoryButton = new JButton("Show Transaction History");

        buttonPanel.add(addIncomeButton);
        buttonPanel.add(addExpenseButton);
        buttonPanel.add(showHistoryButton);

        // Create a wrapper panel for the input and button panels
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the wrapper panel to the JFrame
        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listeners
        addIncomeButton.addActionListener(e -> addIncome());
        addExpenseButton.addActionListener(e -> addExpense());
        showHistoryButton.addActionListener(e -> showTransactionHistory());
    }

    // Method to add income
    private void addIncome() {
        try {
            double income = Double.parseDouble(incomeField.getText());
            balance += income;
            transactionHistory.add("Income: $" + income);
            updateBalanceLabel();
            JOptionPane.showMessageDialog(this, "Income of $" + income + " added.");
            incomeField.setText(""); // Clear input field
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for income.");
        }
    }

    // Method to add expense
    private void addExpense() {
        try {
            double expense = Double.parseDouble(expenseField.getText());
            String reason = reasonField.getText();

            if (expense > balance) {
                JOptionPane.showMessageDialog(this, "Insufficient balance to add this expense.");
            } else {
                balance -= expense;
                transactionHistory.add("Expense: $" + expense + " for " + reason);
                updateBalanceLabel();
                JOptionPane.showMessageDialog(this, "Expense of $" + expense + " for " + reason + " added.");
            }
            expenseField.setText(""); // Clear input field
            reasonField.setText("");  // Clear reason field
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for expense.");
        }
    }

    // Method to show transaction history
    private void showTransactionHistory() {
        transactionArea.setText(""); // Clear previous history
        if (transactionHistory.isEmpty()) {
            transactionArea.append("No transactions found.\n");
        } else {
            transactionArea.append("Transaction History:\n");
            for (String transaction : transactionHistory) {
                transactionArea.append(transaction + "\n");
            }
        }
    }

    // Method to update balance label
    private void updateBalanceLabel() {
        balanceLabel.setText("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BudgetTrackerGUI tracker = new BudgetTrackerGUI();
            tracker.setVisible(true);
        });
    }
}
