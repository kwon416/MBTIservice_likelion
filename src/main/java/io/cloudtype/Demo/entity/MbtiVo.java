package io.cloudtype.Demo.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "MBTI_FEATURE")
@Table(name = "MBTI_FEATURE")
public class MbtiVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "MBTI")
    private String mbti;
    @Column(name = "INFO")
    private String info;

    @Builder
    public MbtiVo(String mbti, String info) {
        this.mbti = mbti;
        this.info = info;
    }
}
