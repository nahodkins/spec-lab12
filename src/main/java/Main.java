import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    private static void getHtmlPage(String pageUrl, String fileName) throws IOException {
        URL url = new URL(pageUrl);
        URLConnection urlConnection = url.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            reader.lines()
                    .forEach(str -> {
                        try {
                            writer.write(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        getHtmlPage("http://proglang.su/java/url-processing", "http-page.html");
        getHtmlPage("https://github.com", "https-page.html");
    }
}
