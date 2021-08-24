package com.koreait.day3.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_user",
        sequenceName = "seq_user",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Long id;        // 일렬번호
    private String userid;  // 아이디
    private String userpw;  // 비밀번호
    private String name;    // 이름
    private String status;  // 상태
    private LocalDateTime lastLoginAt;  // 마지막 접속시간
    @CreatedDate
    private LocalDateTime regDate;      // 가입 날짜

    @CreatedBy
    private String createBy;

}
