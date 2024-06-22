import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        int port = 8081;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            output.write("Привіт!\n");
            output.flush();

             if (StringUtils.containsAny(input.readLine(), "ЁёЪъЫыЭэ")) {
                output.write("Що таке паляниця?\n");
                output.flush();
                if (input.readLine().toLowerCase().contains("хліб")) {
                    output.write("Поточна дата: " + LocalDate.now() + "\n");
                    output.write("Поточний час: " + LocalTime.now());
                    output.write("Гарного вам дня)");
                    output.flush();
                } else {
                    output.write("Remember, no russian");
                    output.flush();
                }
            }

            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
