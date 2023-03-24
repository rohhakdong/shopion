package com.shopion.web;

import com.shopion.security.dto.AuthMemberDto;
import com.shopion.service.NoticeService;
import com.shopion.web.dto.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
@Log4j2
public class IndexController {

    private final NoticeService noticeService;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal AuthMemberDto authMember, Model model) {
        model.addAttribute("noticeList", noticeService.findAll());
        model.addAttribute("authMember", authMember);

        log.info("authMember => " + authMember);

        return "index";
    }

    @GetMapping("/notice/save")
    public String noticeSave() {
        return "noticeSave";
    }

    @GetMapping("/notice/update/{id}")
    public String noticeUpdate(@PathVariable Long id, Model model) {
        NoticeResponseDto dto = noticeService.findById(id);
        model.addAttribute("notice", dto);
        return "noticeUpdate";
    }
}
