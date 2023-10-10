package com.clickbye.api.domain;

import com.clickbye.api.in.Article;
import com.clickbye.api.out.WebPageFetcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindReplacementQueue {

    private final WebPageFetcher webPageFetcher;

    public void schedule(List<Article> pending) {
        for (Article a : pending) {
            String content = webPageFetcher.fetchArticleContent(a.url());
            log.info("Fetch {} {} content: {}", a.title(), a.url(), content);
        }
    }
}
