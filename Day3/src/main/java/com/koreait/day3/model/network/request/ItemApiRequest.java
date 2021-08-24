package com.koreait.day3.model.network.request;

import com.koreait.day3.model.enumclass.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemApiRequest {

    private Long id;
    private String name;
    private ItemStatus status;
    private String title;
    private String content;
    private BigDecimal price;
    private LocalDateTime regDate;
    private String createBy;
    private LocalDateTime updateDate;
    private String updateBy;
}
