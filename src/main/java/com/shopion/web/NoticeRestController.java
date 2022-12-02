package com.shopion.web;

import com.shopion.service.NoticeService;
import com.shopion.web.dto.NoticeResponseDto;
import com.shopion.web.dto.NoticeSaveRequestDto;
import com.shopion.web.dto.NoticeUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class NoticeRestController {

    private final NoticeService noticeService;

    @PostMapping("/rest/v1/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto) {
        return noticeService.save(requestDto);
    }

    @PutMapping("/rest/v1/notice/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeUpdateRequestDto requestDto) {
        return noticeService.update(id, requestDto);
    }

    @GetMapping("/rest/v1/notice/{id}")
    public NoticeResponseDto findById(@PathVariable Long id) {
        return noticeService.findById(id);
    }
}
