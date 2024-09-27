package com.example.lambdatech;



import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatController {

    @FXML
    private ListView<String> userList;

    @FXML
    private VBox messageBox;

    @FXML
    private TextField messageInput;

    private String username;
    private PrintWriter writer;
    private Socket socket;

    private List<String> messages = new ArrayList<>();

    @FXML
    public void initialize() {
        // Initialize connection, possibly open a login window to get the username
        try {
            socket = new Socket("localhost", 12345); // Replace with your server details
            new Thread(new ReceiveMessageTask(socket)).start(); // Multithreaded message receiving
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add initial users (example, real users would come from the server)
        userList.getItems().add("User1");
        userList.getItems().add("User2");
    }

    @FXML
    public void handleSendMessage() {
        String message = messageInput.getText();
        if (!message.isEmpty()) {
            sendMessage(message);
            messageInput.clear();
        }
    }

    private void sendMessage(String message) {
        // Add the message to the local UI
        addMessageToUI("Me: " + message);

        // Send the message to the server
        writer.println(username + ": " + message);  // Send formatted message
    }

    private void addMessageToUI(String message) {
        Platform.runLater(() -> {
            Text text = new Text(message);
            messageBox.getChildren().add(text);
        });
    }

    private class ReceiveMessageTask implements Runnable {
        private BufferedReader reader;

        public ReceiveMessageTask(Socket socket) throws IOException {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    String finalMessage = message;
                    Platform.runLater(() -> addMessageToUI(finalMessage));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
