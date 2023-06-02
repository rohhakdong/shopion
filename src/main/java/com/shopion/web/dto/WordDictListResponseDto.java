package com.shopion.web.dto;

import com.shopion.domain.code.WordDict;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WordDictListResponseDto {

    private String korWord;

    private String engWord;

    private String engAbbr;

    @Builder
    public WordDictListResponseDto(WordDict entity) {
        this.korWord = entity.getKorWord();
        this.engWord = entity.getEngWord();
        this.engAbbr = entity.getEngAbbr();
    }

}
