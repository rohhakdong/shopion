package com.shopion.web.dto;

import com.shopion.domain.code.WordDict;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WordDictSaveRequestDto {

    private String korWord;

    private String engWord;

    private String engAbbr;

    @Builder
    public WordDictSaveRequestDto(String korWord, String engWord, String engAbbr) {
        this.korWord = korWord;
        this.engWord = engWord;
        this.engAbbr = engAbbr;
    }

    public WordDict toEntity() {
        return WordDict.builder()
                .korWord(korWord)
                .engWord(engWord)
                .engAbbr(engAbbr)
                .build();
    }
}
