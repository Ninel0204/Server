import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String... args) {

        try (ServerSocket serverSocket = new ServerSocket(ServicConfig.PORT)) {
            System.out.println("Сервер запущен");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("Подключен клиент " + clientSocket.getPort());
                    Scanner scanner = new Scanner(System.in);
                    out.println(scanner.nextLine());
                    out.println("Hi from server");
                    System.out.println(in.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

