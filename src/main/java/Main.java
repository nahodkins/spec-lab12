import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://proglang.su/java/url-processing");
        URLConnection urlConnection = url.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.html"))) {
            reader.lines()
                    .forEach(str -> {
                        try {
                            writer.write(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
