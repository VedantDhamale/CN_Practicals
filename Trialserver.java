import java.io.*;
import java.net.*;

public class Trialserver {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        Socket client = server.accept();
        InputStream in = client.getInputStream();
        FileOutputStream out = new FileOutputStream("received_file.txt");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
	System.out.println("Received Successfully");
        out.close();
        in.close();
        client.close();
        server.close();
    }
}
