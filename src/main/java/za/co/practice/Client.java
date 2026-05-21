package za.co.practice;

// Used to send messages from client → server
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {

            // Scanner reads what YOU type in the terminal
            Scanner scanner = new Scanner(in);

            // Create a connection to the server running on this computer (localhost)
            // Port 5000 must match the server
            Socket socket = new Socket("localhost", 5001);

            // Confirmation that connection succeeded
            System.out.println("Connected to server!");

            // Output stream: this sends data from client → server
            // true = automatically send data immediately (no buffering delay)
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            //
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // Infinite loop so we can keep sending messages (chat style)
            while (true) {

                // Wait for user to type something in terminal
                String message = scanner.nextLine();

                // Send the typed message to the server through the socket
                out.println(message);

                // WAIT for server reply
                String response = in.readLine();

                // Print Server reply
                System.out.println("Server says: " + response);
            }

        } catch (Exception e) {

            // If connection fails (server not running, wrong port, etc.)
            System.out.println("Could not connect to Server!");
        }
    }
}
