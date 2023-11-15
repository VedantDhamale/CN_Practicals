
import java.io.*;
import java.net.*;

public class TCPClient_hello {
    public static void main(String[] args) {
        String serverHost = "127.0.0.1"; // Change this to the IP address of your server
        int serverPort = 12345; // Change this to the port your server is listening on

        try {
            Socket socket = new Socket(serverHost, serverPort);

            // Create input and output streams for the socket
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Send a "Hello" message to the server
            String message = "Hello";
            out.writeUTF(message);

            // Receive a response from the server
            String response = in.readUTF();
            System.out.println("Server says: " + response);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
