package com.koreait.day3.model.entity;

import com.koreait.day3.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_users",
        sequenceName = "seq_users",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
    private Long id;

    private String userid;
    private String userpw;
    private String hp;
    private String email;
    @CreatedDate
    private LocalDateTime regDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

    @Enumerated(EnumType.STRING)
    private UserStatus status;  // REGISTERED, UNREGISTERED

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<OrderGroup> orderGroupList;
}
