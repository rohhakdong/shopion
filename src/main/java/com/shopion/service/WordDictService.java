package com.shopion.service;

import com.shopion.domain.code.WordDictRepository;
import com.shopion.domain.code.WordDict;
import com.shopion.web.dto.WordDictListResponseDto;
import com.shopion.web.dto.WordDictResponseDto;
import com.shopion.web.dto.WordDictSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WordDictService {

    private final WordDictRepository wordDictRepository;

    @Transactional
    public String save(WordDictSaveRequestDto requestDto) {
        return wordDictRepository.save(requestDto.toEntity()).getKorWord();
    }

    @Transactional
    public String update(String korWord, WordDictSaveRequestDto requestDto) {
        WordDict WordDict = wordDictRepository.findById(korWord)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 단어사전이 없습니다. '" + korWord + "'"));
        WordDict.update(requestDto.getEngWord(),requestDto.getEngAbbr());

        /*
        modelDAO.updateWordDict(wordDict);
        modelAttrDAO.updateWordDict(wordDict);
         */

        return korWord;
    }

    @Transactional
    public void delete (String korWord) {
        WordDict wordDict = wordDictRepository.findById(korWord)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 단어사전이 없습니다. '" + korWord + "'"));
        wordDictRepository.delete(wordDict);
    }

    public String findAbbrById(String korWord) {
        WordDict entity = wordDictRepository.findById(korWord)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 단어사전이 없습니다. '" + korWord + "'"));
        return entity.getEngAbbr();
    }

    public WordDictResponseDto findById(String korWord) {
        WordDict entity = wordDictRepository.findById(korWord)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 단어사전이 없습니다. '" + korWord + "'"));
        return new WordDictResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<WordDictListResponseDto> findAll(String korWord, String engWord) {
        return wordDictRepository.findAll().stream().map(WordDictListResponseDto::new).collect(Collectors.toList());
    }

}
