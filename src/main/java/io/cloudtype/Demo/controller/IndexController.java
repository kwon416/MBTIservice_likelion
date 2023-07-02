package io.cloudtype.Demo.controller;

import io.cloudtype.Demo.entity.MbtiVo;
import io.cloudtype.Demo.service.MbtiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final MbtiService mbtiService;
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/admin")
    public String admin(Model model) {
        List<MbtiVo> voList = mbtiService.findAll();
        model.addAttribute("MbtiList", voList);
        return "admin";
    }
}
