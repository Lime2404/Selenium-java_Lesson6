package Lesson_6.utils;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;

import java.io.IOException;

public class HttpClientExample {
    public static void main(String[] args) {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://demoqa.com/");

        try {
            HttpResponse response = client.execute(request);
            System.out.println("Response Code: " + response.getCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
