package com.clickbye.api.in;

import com.clickbye.api.domain.FindReplacementQueue;
import com.clickbye.api.domain.ReplacementFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SummaryController {

    private final ReplacementFetcher replacementCache;
    private final FindReplacementQueue findReplacementQueue;

    @PostMapping(path = "/summary", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<TitleReplacement> fetchReplacements(@RequestBody List<Article>  articles) {
        findReplacementQueue.schedule(articles);
        return replacementCache.getCachedReplacements(articles);
    }
}
