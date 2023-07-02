package io.cloudtype.Demo.controller;

import io.cloudtype.Demo.entity.MbtiVo;
import io.cloudtype.Demo.service.MbtiService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mbti")
public class MbtiController {
    private final MbtiService mbtiService;

    //저장된 모든 MBTI 특징조회
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MbtiVo>> findAll(Model model) {
        List<MbtiVo> mbtiVos = mbtiService.findAll();
        return new ResponseEntity<List<MbtiVo>>(mbtiVos, HttpStatus.OK);
    }

    //특정 MBTI 랜덤 특징 조회
    @GetMapping(value = "/{mbti}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getMbti(@PathVariable("mbti") String mbti) {
        Optional<MbtiVo> mbtiVo = mbtiService.findByMbti(mbti);
        if (mbtiVo.isPresent()) {
            return new ResponseEntity(mbtiVo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("No Such Value : "+ mbti,HttpStatus.OK);
        }

    }

    // 내 MBTI 정보 입력
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity save(@RequestBody MbtiVo mbtiVo) {
        ArrayList<String> mbtiList = new ArrayList<>(Arrays.asList(
                "ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP",
                "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"
        ));
        if (!mbtiList.contains(mbtiVo.getMbti())) {
            System.out.println("input mbti :" + mbtiVo.getMbti());
            return new ResponseEntity("bad request -- mbti input: " + mbtiVo.getMbti(), HttpStatus.OK);
        }
        MbtiVo mbtiVo1 = mbtiService.save(mbtiVo);
        return new ResponseEntity(mbtiVo1, HttpStatus.OK);
    }

    // ID 값으로 MBTI 특징 삭제
    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mbtiService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
