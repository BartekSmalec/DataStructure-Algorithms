package multithreading.httpserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputHttpServer {

    public static final String INPUT_FILE = "src/main/resources/war_and_peace.txt";
    private static int NUMBER_OF_THREADS = 1;

    public static void main(String[] args) throws IOException {
/*        List<String> strings = Arrays.asList("A", "asda", "A", "A");
        Map<String, AtomicInteger> map = new HashMap<>();
        strings.forEach(s -> map.computeIfAbsent(s, k -> new AtomicInteger(0)).incrementAndGet());
        map.forEach((k, v) -> System.out.println("Key:  " + k + " value: " + v));*/
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        startServer(text);
    }

    public static void startServer(String text) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/search", new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        httpServer.setExecutor(executor);
        httpServer.start();
    }

    private static class WordCountHandler implements HttpHandler {
        private String text;

        public WordCountHandler(String text) {
            this.text = text;
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String query = httpExchange.getRequestURI().getQuery();
            String[] keyValue = query.split("=");
            String action = keyValue[0];
            String word = keyValue[1];
            if (!action.equals("word")) {
                httpExchange.sendResponseHeaders(400, 0);
                return;
            }
            long count = countWord(word);
            byte[] response = Long.toString(count).getBytes();

            httpExchange.sendResponseHeaders(200, response.length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response);
            outputStream.close();
        }

        private long countWord(String word) {
            long count = 0;
            int index = 0;
            while (index >= 0) {
                index = text.indexOf(word, index);
                if (index >= 0) {
                    count++;
                    index++;
                }
            }
            return count;
        }
    }
}
