package com.tronina.cs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;


public class Controller {
    public static final String CONTRACTS_API_URL = "http://localhost:8081/contracts/";

    private Contract model;
    private HttpClient client = HttpClient.newHttpClient();

    public List<Contract> getData() {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(CONTRACTS_API_URL))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(response.body(), new TypeReference<List<Contract>>(){});
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}