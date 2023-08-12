package weatherapp;

import weatherapp.Constants.Pair;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import java.util.regex.*;

public class App {
    public static void main(String[] args) throws Exception {
        HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(buildURI("http://api.weatherapi.com/v1/current.json", Constants.LOCATION_IDENTIFIER, Constants.API_KEY))
            .POST(BodyPublishers.noBody())
            .build();
        
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
        
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.body());
        System.out.println(postResponse.headers());


    }
    
    public static URI buildURI(String baseURI, Pair... queryPairs) throws URISyntaxException {
        StringBuilder stringBuilder = new StringBuilder(baseURI);

        if (queryPairs.length == 0) { return new URI(stringBuilder.toString()); }

        stringBuilder.append("?" + queryPairs[0].name + "=" + queryPairs[0].value);

        for (int i = 1; i < queryPairs.length; i++) {
            stringBuilder.append("&" + queryPairs[i].name + "=" + queryPairs[i].value);
        }

        return new URI(stringBuilder.toString());
    }
}