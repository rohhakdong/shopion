package com.shopion.web;

import com.shopion.service.WordDictService;
import com.shopion.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WordDictRestController {

    private final WordDictService wordDictService;

    @PostMapping("/rest/v1/wordDict")
    public String save(@RequestBody WordDictSaveRequestDto requestDto) {
        return wordDictService.save(requestDto);
    }

    @PutMapping("/rest/v1/wordDict/{korWord}")
    public String update(@PathVariable String korWord, @RequestBody WordDictSaveRequestDto requestDto) {
        return wordDictService.update(korWord, requestDto);
    }

    @DeleteMapping("/rest/v1/wordDict/{korWord}")
    public String delete(@PathVariable String korWord) {
        wordDictService.delete(korWord);
        return korWord;
    }

    @GetMapping("/rest/v1/wordDict/{korWord}&{engWord}")
    public List<WordDictListResponseDto> findAll(@PathVariable String korWord, @PathVariable String engWord) {
        return wordDictService.findAll(korWord, engWord);
    }
}
