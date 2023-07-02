package io.cloudtype.Demo.repository;

import io.cloudtype.Demo.entity.MbtiVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MbtiRepository extends JpaRepository<MbtiVo, Long> {

    @Query(value = "select * from MBTI_FEATURE m where m.MBTI= :mbti order by rand() limit 1", nativeQuery = true)
    Optional<MbtiVo> findByMbti(@Param("mbti") String mbti);
}
