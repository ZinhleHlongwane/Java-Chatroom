package za.co.practice;

import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to server!");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hello Server");

        } catch (Exception e) {
            System.out.println("Could not connect to Server!");
        }
    }
}
