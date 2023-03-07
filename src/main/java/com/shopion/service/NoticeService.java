package com.shopion.service;

import com.shopion.domain.notice.Notice;
import com.shopion.domain.notice.NoticeRepository;
import com.shopion.web.dto.NoticeListResponseDto;
import com.shopion.web.dto.NoticeResponseDto;
import com.shopion.web.dto.NoticeSaveRequestDto;
import com.shopion.web.dto.NoticeUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

    @RequiredArgsConstructor
    @Service
    public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public Long save(NoticeSaveRequestDto requestDto) {
        return noticeRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, NoticeUpdateRequestDto requestDto) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 공지사항이 없습니다. id=" + id));
        notice.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public NoticeResponseDto findById(Long id) {
        Notice entity = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 공지사항이 없습니다. id=" + id));
        return new NoticeResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<NoticeListResponseDto> findAll() {
        return noticeRepository.findAll().stream().map(NoticeListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notice number " + id + " does not exist"));
        noticeRepository.delete(notice);
    }
}
