import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class Server extends JFrame {
    private static final int TIMEOUT_SECONDS = 30;  // Timeout set to 30 seconds
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    private JTextField inputField;
    private JButton clearChatButton, deleteChatButton;
    private DefaultListModel<String> chatListModel;
    private JList<String> chatList;

    private ScheduledExecutorService scheduler; // For inactivity timeout
    private long lastActivityTime; // To track the last activity timestamp

    public Server() {
        try {
            server = new ServerSocket(7777);
            System.out.println("Server is ready.");
            socket = server.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            createGUI();
            handleEvents();

            // Start reading messages and start the inactivity checker
            startReading();
            startInactivityChecker();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createGUI() {
        this.setTitle("Server");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField();

        JPanel topPanel = new JPanel();
        clearChatButton = new JButton("Clear Chat");
        deleteChatButton = new JButton("Delete Selected Chat");
        topPanel.add(clearChatButton);
        topPanel.add(deleteChatButton);

        chatListModel = new DefaultListModel<>();
        chatList = new JList<>(chatListModel);
        JScrollPane scrollPane = new JScrollPane(chatList);

        this.setLayout(new java.awt.BorderLayout());
        this.add(topPanel, "North");
        this.add(scrollPane, "Center");
        this.add(inputField, "South");

        this.setVisible(true);
    }

    private void handleEvents() {
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                if (!message.isEmpty()) {
                    String formattedMessage = "Me: " + message + " [" + getCurrentTime() + "]";
                    chatListModel.addElement(formattedMessage);
                    out.println(message);
                    inputField.setText("");
                    if (message.equals("exit")) {
                        System.exit(0);
                    }
                    resetInactivityTimer(); // Reset inactivity timer when message is sent
                }
            }
        });

        clearChatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chatListModel.clear();
            }
        });

        deleteChatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = chatList.getSelectedIndex();
                if (selectedIndex != -1) {
                    chatListModel.remove(selectedIndex);
                }
            }
        });
    }

    public void startReading() {
        Runnable r = () -> {
            try {
                String msg;
                while ((msg = br.readLine()) != null) {
                    String formattedMessage = "Client: " + msg + " [" + getCurrentTime() + "]";
                    chatListModel.addElement(formattedMessage);
                    resetInactivityTimer(); // Reset inactivity timer when message is received
                    if (msg.equals("exit")) {
                        socket.close();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(r).start();
    }

    private void startInactivityChecker() {
        scheduler = Executors.newScheduledThreadPool(1);
        lastActivityTime = System.currentTimeMillis(); // Initialize the activity time

        // Schedule a task to check for inactivity every second
        scheduler.scheduleAtFixedRate(() -> {
            long currentTime = System.currentTimeMillis();
            long inactivityDuration = currentTime - lastActivityTime;

            if (inactivityDuration >= TIMEOUT_SECONDS * 1000) {
                // If inactivity duration exceeds the set timeout, show dialog and disconnect
                try {
                    closeGUI();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scheduler.shutdown();
            }
        }, 1, 1, TimeUnit.SECONDS); // Check every second
    }

    private void resetInactivityTimer() {
        lastActivityTime = System.currentTimeMillis(); // Update the last activity time
    }

    private void closeGUI() throws IOException {
        // Close the GUI after showing a message dialog
        SwingUtilities.invokeLater(() -> {
            int choice = JOptionPane.showConfirmDialog(this, "No activity for 30 seconds. Disconnecting...", "Timeout", JOptionPane.OK_CANCEL_OPTION);
            if (choice == JOptionPane.OK_OPTION) {
                out.println("disconnect");  // Send a disconnect message to the client
                this.dispose();  // Close the server GUI
                System.exit(0);   // Exit the application
            }
        });
    }

    private String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return formatter.format(new Date());
    }

    public static void main(String[] args) {
        new Server();
    }
}
