package com.clickbye.api.in;

import com.clickbye.api.domain.Replacement;

public record TitleReplacement(String original, String replacement) {
    public static TitleReplacement from(Replacement cache) {
        return new TitleReplacement(cache.getTitle(), cache.getReplacement());
    }
}
