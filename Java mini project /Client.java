import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client extends JFrame {
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    private JTextArea messagesArea;
    private JTextField inputField;
    private JButton clearChatButton, deleteChatButton;
    private DefaultListModel<String> chatListModel;
    private JList<String> chatList;

    public Client() {
        try {
            socket = new Socket("127.0.0.1", 7777);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            createGUI();
            handleEvents();

            startReading();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createGUI() {
        this.setTitle("Client");
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
                    if (msg.equals("disconnect")) {
                        // Close the client GUI if the server sends a "disconnect" message
                        JOptionPane.showMessageDialog(this, "Server has disconnected due to inactivity.");
                        this.dispose();  // Close the client GUI
                        System.exit(0);  // Exit the application
                    }
                    String formattedMessage = "Server: " + msg + " [" + getCurrentTime() + "]";
                    chatListModel.addElement(formattedMessage);
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

    private String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return formatter.format(new Date());
    }

    public static void main(String[] args) {
        new Client();
    }
}
