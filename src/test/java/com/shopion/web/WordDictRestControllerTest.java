package com.shopion.web;

import com.shopion.domain.code.WordDict;
import com.shopion.domain.code.WordDictRepository;
import com.shopion.web.dto.WordDictSaveRequestDto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WordDictRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WordDictRepository wordDictRepository;

    @AfterEach
    public void tearDown() throws Exception {
        wordDictRepository.deleteAll();
    }

    @Test
    public void wordDictSave() throws Exception {
        String korWord = "계좌";
        String engWord = "account";
        String engAbbr = "acnt";

        WordDictSaveRequestDto requestDto = WordDictSaveRequestDto.builder()
                .korWord(korWord)
                .engWord(engWord)
                .engAbbr(engAbbr)
                .build();

        String url = "http://localhost:" + port + "/rest/v1/wordDict";

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestDto, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        //assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<WordDict> all = wordDictRepository.findAll();
        assertThat(all.get(0).getKorWord()).isEqualTo(korWord);
        assertThat(all.get(0).getEngWord()).isEqualTo(engWord);
        assertThat(all.get(0).getEngAbbr()).isEqualTo(engAbbr);

    }

    @Test
    public void WordDictUpdate() throws Exception {
        String korWord = "계좌";
        String engWord = "account";
        String engAbbr = "acnt";

        WordDict wordDict = wordDictRepository.save(WordDict.builder()
                .korWord(korWord)
                .engWord(engWord)
                .engAbbr(engAbbr)
                .build());

        String updateKorword = wordDict.getKorWord();
        String expectedEngWord = "account1";
        String expectedEngAbbr = "acnt1";

        WordDictSaveRequestDto requestDto = WordDictSaveRequestDto.builder()
                .engWord(expectedEngWord)
                .engAbbr(expectedEngAbbr)
                .build();

        String url = "http://localhost:" + port + "/rest/v1/wordDict/" + updateKorword;

        HttpEntity<WordDictSaveRequestDto> requestEntity = new HttpEntity<>(requestDto);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        //assertThat(responseEntity.getBody()).isGreaterThan((0L));

        List<WordDict> all = wordDictRepository.findAll();
        assertThat(all.get(0).getEngWord()).isEqualTo(expectedEngWord);
        assertThat(all.get(0).getEngAbbr()).isEqualTo(expectedEngAbbr);

    }
}
