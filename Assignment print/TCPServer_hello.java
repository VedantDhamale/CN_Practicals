import java.io.*;
import java.net.*;

public class TCPServer_hello {
    public static void main(String[] args) {
        int port = 12345; // Change this to the port you want the server to listen on

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress());

                // Create input and output streams for the client socket
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Receive the "Hello" message from the client
                String message = in.readUTF();
                System.out.println("Client says: " + message);

                // Send a "Hello" response back to the client
                String response = "Hello from Server";
                out.writeUTF(response);

                // Close the client socket
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
