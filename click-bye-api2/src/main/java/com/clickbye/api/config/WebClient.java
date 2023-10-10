package com.clickbye.api.config;

import org.apache.hc.client5.http.impl.DefaultRedirectStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class WebClient {

    public static RestTemplate createRestTemplateWithRedirects() {

        // Create a request factory with the custom HttpClient

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setRedirectStrategy(new DefaultRedirectStrategy())
                .build()) {
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
            return new RestTemplate(factory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String urlWithRedirect = "http://example.com"; // Replace with your URL

        // Create a RestTemplate that follows redirects
        RestTemplate restTemplate = createRestTemplateWithRedirects();

        // Make a GET request
        String response = restTemplate.getForObject(urlWithRedirect, String.class);

        // Process the response as needed
        System.out.println(response);
    }
}
