package org.example.randomuser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Random {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://randomuser.me/api/");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();

            System.out.println("Response from API:");
            System.out.println(responseBuilder.toString());

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}