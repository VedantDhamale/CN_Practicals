import java.io.*;
import java.net.*;

public class TCPClient6{
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 3333)) {
            try (DataInputStream din = new DataInputStream(clientSocket.getInputStream());
                 DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream())) {

                // Say "Hello" to the server
                dout.writeUTF("Hello, Server!");
                String serverResponse = din.readUTF();
                System.out.println("Received from server: " + serverResponse);

                // Send a file to the server
                String fileName = "sample.txt";
                File file = new File(fileName);
                dout.writeUTF(fileName);
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    dout.write(buffer, 0, bytesRead);
                }
                fis.close();

                System.out.println("File sent to server: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
