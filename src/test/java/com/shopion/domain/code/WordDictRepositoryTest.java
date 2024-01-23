package com.shopion.domain.code;

import com.shopion.domain.code.WordDict;
import com.shopion.domain.code.WordDictRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WordDictRepositoryTest {

    @Autowired
    WordDictRepository wordDictRepository;

    @AfterEach
    public void cleanup() {
        wordDictRepository.deleteAll();
    }

    @Test
    public void save() {
        String korWord = "계좌";
        String engWord = "account";
        String engAbbr = "acnt";

        wordDictRepository.save(
                WordDict.builder()
                        .korWord(korWord)
                        .engWord(engWord)
                        .engAbbr(engAbbr)
                        .build()
        );

        List<WordDict> wordDictList = wordDictRepository.findAll();

        WordDict wordDict = wordDictList.get(0);
        assertThat(wordDict.getKorWord()).isEqualTo(korWord);
        assertThat(wordDict.getEngWord()).isEqualTo(engWord);
        assertThat(wordDict.getEngAbbr()).isEqualTo(engAbbr);
    }

}
