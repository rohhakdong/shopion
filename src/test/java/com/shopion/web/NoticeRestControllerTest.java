package com.shopion.web;

import com.shopion.domain.notice.Notice;
import com.shopion.domain.notice.NoticeRepository;
import com.shopion.web.dto.NoticeResponseDto;
import com.shopion.web.dto.NoticeSaveRequestDto;
import com.shopion.web.dto.NoticeUpdateRequestDto;
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
public class NoticeRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private NoticeRepository noticeRepository;

    @AfterEach
    public void tearDown() throws Exception {
        noticeRepository.deleteAll();
    }

    @Test
    public void noticeSave() throws Exception {
        String title = "notice title";
        String content = "notice content";
        NoticeSaveRequestDto requestDto = NoticeSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("rohhakdong@gmail.com")
                .build();

        String url = "http://localhost:" + port + "/rest/v1/notice";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Notice> all = noticeRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);

    }

    @Test
    public void noticeUpdate() throws Exception {
        Notice notice = noticeRepository.save(Notice.builder()
                        .title("notice title")
                        .content("notice content")
                        .author("notice author")
                .build());

        Long updateId = notice.getId();
        String expectedTitle = "notice title updated";
        String expectedContent = "notice content updated";

        NoticeUpdateRequestDto requestDto = NoticeUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/rest/v1/notice/" + updateId;

        HttpEntity<NoticeUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan((0L));

        List<Notice> all = noticeRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);

    }
}
