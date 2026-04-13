package za.co.practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);

            System.out.println("Waiting for client...");

            Socket socket = server.accept();

            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String message = in.readLine();

            System.out.println("Client says: " + message);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}
