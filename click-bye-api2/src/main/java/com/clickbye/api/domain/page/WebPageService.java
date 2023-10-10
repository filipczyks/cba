package com.clickbye.api.domain.page;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WebPageService {

    @Autowired
    private RestTemplate restTemplate;

    public Set<String> fetchParapgraphs(String url) {
        log.info("url: {}", url);
        // Fetch the web page content as a String
        String decodedUrl = URLDecoder.decode(url, StandardCharsets.UTF_8);
        log.info("decoded: {}", decodedUrl);


        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.0.0 Safari/537.36");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // Use Jsoup to parse the HTML content
        Document document = Jsoup.parse(response.getBody());

        Elements ps = document.select("p");

        return ps.stream().map(Element::text).collect(Collectors.toSet());
    }
}