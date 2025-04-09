package net.chatapp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class that listens for client connections and reads messages.
 */
public class Server {
    private ServerSocket server;                    // Server socket
    private DataInputStream in;                     // DataInputStream to read incoming messages
    public static final int PORT = 3030;            // Port number for the server
    public static final String STOP_STRING = "##";  // Stop string to terminate the connection

    /**
     * Creates a server socket and starts listening for connections when a Server object is instantiated.
     */
    public Server() {
        try {
            // Create a server socket on the specified port
            server = new ServerSocket(PORT);

            // Initialize client connections
            iniConnections();
        } catch (IOException e) {
            // Throw a RuntimeException if an error occurs
            throw new RuntimeException(e);
        }
    }

    /**
     * Accepts client connections and starts reading messages.
     * @throws IOException
     */
    private void iniConnections() throws IOException {
        // Accept a client connection
        Socket clientSocket = server.accept();

        // Create a DataInputStream to read from the client
        in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));

        // Read messages from the client
        readMessages();

        // Close the connection
        close();
    }

    /**
     * Closes the DataInputStream and server socket.
     * @throws IOException
     */
    private void close() throws IOException {
        // Close the DataInputStream
        in.close();

        // Close the server socket
        server.close();
    }

    /**
     * Reads messages from the client and prints them to the console until the stop string is received.
     * @throws IOException
     */
    private void readMessages() throws IOException {
        String line = "";
        while (!line.equals(STOP_STRING)) {
            // Read a message from the client
            line = in.readUTF();

            // Print the message to the console
            System.out.println(line);
        }
    }

    /**
     * Main method to start the server.
     * @param args
     */
    public static void main(String[] args) {
        // Create a new Server object
        new Server();
    }
}