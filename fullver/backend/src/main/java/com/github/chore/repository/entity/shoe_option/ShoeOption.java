package com.github.chore.repository.entity.shoe_option;

import com.github.chore.repository.entity.shoe.Shoe;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@Entity
@Table(name = "shoe_option")
public class ShoeOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoe_option_id", nullable = false)
    private Integer shoeOptionId;

    @ManyToOne
    @JoinColumn(name="shoe_id",nullable = false)
    private Shoe shoe;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "size", nullable = false)
    private Integer size;

    @Column(name = "option_etc", length = 50)
    private String optionEtc;

    @Builder.Default
    @Column(name="sort_order")
    private Integer sortOrder = 0;

    @Builder.Default
    @Column(name = "additional_price")
    private BigDecimal additionalPrice = BigDecimal.valueOf(0);

    @Column(name = "sku", nullable = false)
    private String sku;

    @Builder.Default
    @Column(name = "is_active",nullable = false) // 활성화여부
    private Boolean isActive = Boolean.valueOf(true);

    @Column(name = "cache_key",length = 100) //TODO redis 연결 시 확인 및 수정
    private String cacheKey;

    @Column(name = "sync_enabled") // 해당 레코드(상품, 재고, 계정 등)가 외부 시스템 또는 다른 DB와 동기화 가능한 상태인지 표시
    private Boolean syncEnabled;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        if (shoe == null || shoe.getShoeId() == null) {
            throw new IllegalStateException("ShoeOption 생성 시 반드시 Shoe가 존재해야 합니다.");
        }

        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;

        String datePart = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        StringBuilder sb = new StringBuilder();

        sb.append("SH");
        sb.append(shoe.getShoeId());
        sb.append("-");
        sb.append(color.toUpperCase().replaceAll("\\s+", ""));
        sb.append("-");
        sb.append(size);
        sb.append("-");
        sb.append(datePart);

        this.sku = sb.toString();
    }



    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


}
