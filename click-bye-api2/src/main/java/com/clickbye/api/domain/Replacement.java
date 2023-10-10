package com.clickbye.api.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Replacement {
    private Id id;
    private String title;
    private String url;
    private String replacement;

    public record Id(String title) {

    }
}
