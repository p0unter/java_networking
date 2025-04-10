# Server-Client Communication System
## Overview
This system allows for basic communication between a server and a client. The server listens for incoming connections and reads messages from the client, while the client connects to the server and sends messages.

## Key Features
- **Server**: Listens on a specified port (`3030`) for incoming connections.
- **Client**: Connects to the server at `127.0.0.1` on port `3030`.
- **Message Handling**: Messages sent by the client are printed to the server's console.
- **Stop String**: The connection is terminated when the client sends the string `"##"`.

## Usage
1. Run the server by executing the `Server` class.
2. Run the client by executing the `Client` class.
3. In the client console, type messages and press Enter to send them to the server.
4. The server will print each received message to its console.
5. To stop the communication, type `"##"` in the client console.
