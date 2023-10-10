package com.clickbye.api.domain;

import com.clickbye.api.in.Article;
import com.clickbye.api.in.TitleReplacement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplacementFetcher {

    private final ReplacementRepository replacementRepository;

    public List<TitleReplacement> getCachedReplacements(List<Article> articles) {
        List<String> titles = extractTitles(articles);
        List<Replacement> cached = replacementRepository.findAllByTitleIn(titles);
        return mapResult(cached);
    }

    private List<TitleReplacement> mapResult(List<Replacement> result) {
        return result.stream()
                .map(TitleReplacement::from)
                .toList();
    }

    private List<String> extractTitles(List<Article> articles) { //add sourceUrl to Article
        return articles.stream()
                .map(Article::title)
                .toList();
    }
}
