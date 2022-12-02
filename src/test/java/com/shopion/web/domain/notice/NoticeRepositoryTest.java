package com.shopion.web.domain.notice;

import com.shopion.domain.notice.Notice;
import com.shopion.domain.notice.NoticeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NoticeRepositoryTest {

    @Autowired
    NoticeRepository noticeRepository;

    @AfterEach
    public void cleanup() {
        noticeRepository.deleteAll();
    }

    @Test
    public void save() {
        String title = "test notice";
        String content = "test content";

        noticeRepository.save(
                Notice.builder()
                        .title(title)
                        .content(content)
                        .author("rohhakdong@gmail.com")
                        .build()
        );

        List<Notice> noticeList = noticeRepository.findAll();

        Notice notice = noticeList.get(0);
        assertThat(notice.getTitle()).isEqualTo(title);
        assertThat(notice.getContent()).isEqualTo(content);
    }
}
