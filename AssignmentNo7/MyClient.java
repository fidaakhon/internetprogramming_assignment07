package AssignmentNo7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected to server: " + socket.getInetAddress());

            // Setup communication streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send message to the server
            String clientMessage = "Hello My name is John";
            out.println(clientMessage);
            System.out.println("Sent to server: " + clientMessage);

            // Receive response from the server
            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

            // Close resources
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

