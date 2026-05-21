package za.co.practice;

// Reads text coming FROM the client
import java.io.BufferedReader;

// Converts raw byte stream into readable text
import java.io.InputStreamReader;

// Creates a server that listens for connections
import java.io.PrintWriter;
import java.net.ServerSocket;

// Represents the connection between server and client
import java.net.Socket;


public class Server {
    public static void main(String[] args) {

        try {

            // Start a server and open port 5000 for incoming connections
            ServerSocket server = new ServerSocket(5001);

            // Inform that server is waiting
            System.out.println("Waiting for client...");

            // Pause here until a client connects
            // Once connected, a Socket is created for communication
            Socket socket = server.accept();

            // Confirmation that a client has connected
            System.out.println("Client connected!");

            // Input stream: receives data from client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            //Send messages to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Infinite loop so server keeps listening for messages
            while (true) {

                // Wait or Receive for a message from the client (blocks until message arrives)
                String message = in.readLine();

                // Print or Show message received from client
                out.println("Client says: " + message);

                // Send a response BACK to the client
                out.println("Server received: " + message);
            }

        } catch (Exception e) {

            // Handles errors like port already in use, connection failure, etc.
            // System.out.println("Something went wrong.");

            e.printStackTrace();
        }
    }
}