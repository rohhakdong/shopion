package com.shopion.web;

import com.shopion.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final NoticeService noticeService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("noticeList", noticeService.findAll());
        return "index";
    }

    @GetMapping("/notice/save")
    public String noticeSave() {
        return "noticeSave";
    }
}
