package com.clickbye.api.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WebPageFetcher {

    private final RestTemplate restTemplate;

    public String fetchArticleContent(String url) {
        String body = restTemplate.getForObject(url, String.class);
        return extractContent(body);
    }

    private String extractContent(String body) {
        return body;
    }
}
