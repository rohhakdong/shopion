package com.shopion.domain.code;

import com.shopion.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class WordDict extends BaseEntity {

    @Id
    private String korWord;

    private String engWord;

    @Column(length = 6, nullable = false)
    private String engAbbr;

    @Builder
    public WordDict (String korWord, String engWord, String engAbbr) {
        this.korWord = korWord;
        this.engWord = engWord;
        this.engAbbr = engAbbr;
    }

    public void update(String engWord, String engAbbr) {
        this.engWord = engWord;
        this.engAbbr = engAbbr;
    }
}
