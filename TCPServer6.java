import java.io.*;
import java.net.*;

public class TCPServer6 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3333)) {
            System.out.println("Server is running and waiting for connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getInetAddress());

                try (DataInputStream din = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream())) {

                    String clientMessage = din.readUTF();
                    System.out.println("Received from client: " + clientMessage);

                    dout.writeUTF("Server says: Hello!");

                    // Receive a file from the client
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    String fileName = din.readUTF();
                    File file = new File(fileName);
                    FileOutputStream fos = new FileOutputStream(file);
                    while ((bytesRead = din.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                    fos.close();

                    System.out.println("File received from client: " + fileName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
