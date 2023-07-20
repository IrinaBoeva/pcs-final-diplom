import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8989)) { // стартуем сервер один(!) раз
            BooleanSearchEngine engine = new BooleanSearchEngine(new File("pdfs"));
            System.out.println(engine.search("бизнес"));
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream())
                ) {
                    String request = in.readLine().toLowerCase();
                    String answer = engine.search(request).toString();
                    out.println(answer);
                    System.out.println(request);
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}