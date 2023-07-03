package io.cloudtype.Demo.controller;

import io.cloudtype.Demo.entity.MbtiVo;
import io.cloudtype.Demo.service.MbtiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/result/{mbti}")
    public String result(@PathVariable("mbti") String mbti, Model model) {

        Optional<MbtiVo> mbtiVo = mbtiService.findByMbti(mbti);
        if (mbtiVo.isPresent()) {
            model.addAttribute("mbti", mbtiVo.get());
            return "result";
        } else {
            return "error";
        }


    }
}
