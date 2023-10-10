package com.clickbye.api.in;

import com.clickbye.api.domain.page.WebPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/page")
@Slf4j
public class WebPageController {

    @Autowired
    private WebPageService webPageService;

    @PostMapping
    public Set<String> fetchAndStripHtml(@RequestBody String url) {
        log.info("url {}", url);
        Set<String> ps = webPageService.fetchParapgraphs(url);
        log.info("{}", ps);
        return ps;
    }
}