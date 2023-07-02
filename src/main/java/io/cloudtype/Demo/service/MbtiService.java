package io.cloudtype.Demo.service;

import io.cloudtype.Demo.entity.MbtiVo;
import io.cloudtype.Demo.repository.MbtiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.geom.AreaOp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MbtiService {
    @Autowired
    private MbtiRepository mbtiRepository;

    public List<MbtiVo> findAll() {
        List<MbtiVo> mbtiVoList = new ArrayList<>(mbtiRepository.findAll());
        return mbtiVoList;
    }

    public Optional<MbtiVo> findByMbti(String mbti) {
        return mbtiRepository.findByMbti(mbti);

    }

    public void deleteById(Long id) {
        mbtiRepository.deleteById(id);
    }

    public MbtiVo save(MbtiVo mbtiVo) {

        mbtiRepository.save(mbtiVo);
        return  mbtiVo;
    }



}
