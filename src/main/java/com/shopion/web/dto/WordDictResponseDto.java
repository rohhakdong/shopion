package com.shopion.web.dto;

import com.shopion.domain.code.WordDict;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class WordDictResponseDto {

    private String korWord;

    private String engWord;

    private String engAbbr;

    private LocalDateTime modifiedDate;

    @Builder
    public WordDictResponseDto(WordDict entity) {
        this.korWord = entity.getKorWord();
        this.engWord = entity.getEngWord();
        this.engAbbr = entity.getEngAbbr();
        this.modifiedDate = entity.getModifiedDate();
    }

}
