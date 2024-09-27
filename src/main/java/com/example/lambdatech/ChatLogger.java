package com.example.lambdatech;

import java.io.FileWriter;
import java.io.IOException;

public class ChatLogger {

    public static void logMessage(String message) {
        try (FileWriter writer = new FileWriter("chat_log.txt", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

