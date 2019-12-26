import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BasicHTTPServer {

    //These values can be changed
    private final static int PORT_NUMBER = 8080;
    private final static String MESSAGE = "Successfully connected";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
        System.out.println("Listening for connection on port: " + PORT_NUMBER);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + MESSAGE;
            clientSocket.getOutputStream().write(
                    httpResponse.getBytes(StandardCharsets.UTF_8)
            );
            clientSocket.close();
        }
    }
}
