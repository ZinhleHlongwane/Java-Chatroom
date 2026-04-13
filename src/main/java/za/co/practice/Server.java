package za.co.practice;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);

            System.out.println("Waiting for client...");

            Socket socket = server.accept();

            System.out.println("Client connected!");
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}
