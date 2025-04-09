package net.chatapp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client class that connects to the server and sends messages.
 */
public class Client {
    private Socket socket;          // Client socket
    private DataOutputStream out;   // DataOutputStream to send messages to the server
    private Scanner in;             // Scanner to read user input

    /**
     * Connects to the server and starts sending messages when a Client object is instantiated.
     */
    public Client() {
        try {
            // Connect to the server at the specified host and port
            socket = new Socket("127.0.0.1", Server.PORT);

            // Create a DataOutputStream to send messages to the server
            out = new DataOutputStream(socket.getOutputStream());

            // Create a Scanner to read user input
            in = new Scanner(System.in);

            // Send messages to the server
            writeMessages();
        } catch (IOException e) {
            // Throw a RuntimeException if an error occurs
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads messages from the user and sends them to the server until the stop string is entered.
     * @throws IOException
     */
    private void writeMessages() throws IOException {
        String line = "";
        while (!line.equals(Server.STOP_STRING)) {
            // Read a message from the user
            line = in.nextLine();

            // Send the message to the server
            out.writeUTF(line);
        }

        // Close the connection
        close();
    }

    /**
     * Closes the socket, DataOutputStream, and Scanner.
     * @throws IOException
     */
    private void close() throws IOException {
        // Close the socket
        socket.close();

        // Close the DataOutputStream
        out.close();

        // Close the Scanner
        in.close();
    }

    /**
     * Main method to start the client.
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Client object
        new Client();
    }
}