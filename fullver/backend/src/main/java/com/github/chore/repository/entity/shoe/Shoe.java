package com.github.chore.repository.entity.shoe;

import com.github.chore.repository.entity.category.Category;
import com.github.chore.repository.entity.image.Image;
import com.github.chore.repository.entity.option.ShoeOption;
import com.github.chore.repository.entity.seller.Seller;
import com.github.chore.repository.entity.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.BindParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "shoe")
@Entity
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoe_id", nullable = false)
    private Integer shoeId;

    @OneToOne
    @JoinColumn(name = "shoe_option_id", nullable = false)
    private ShoeOption shoeOption;

    @ManyToOne
    @JoinColumn(name="seller_id",nullable = false)
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "shoe_name",nullable = false) // 255자는 비활성화됨 왜?
    private String shoeName;

    @Column(name = "price", nullable = false)
    private BigDecimal Price;

    @Builder.Default
    @Column(name = "total_sales")
    private BigDecimal totalSales = BigDecimal.valueOf(0);

    @Builder.Default
    @Column(name = "discount_price")
    private BigDecimal discountPrice = BigDecimal.valueOf(0);

    @Builder.Default
    @Column(name = "discount_rate")
    private BigDecimal discountRate = BigDecimal.valueOf(0);

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(name = "discount_priority")
    private DiscountPriority discountPriority;

    @Builder.Default
    @Column(name = "view_count")
    private Integer viewCount = 0;

    @Builder.Default
    @Column(name= "like_count")
    private Integer likeCount = 0;

    @Builder.Default
    @Column(name="review_count")
    private Integer reviewCount = 0;

    @Builder.Default
    @Column(name = "rating_avg")
    private BigDecimal ratingAvg = BigDecimal.valueOf(0);

    @Builder.Default
    @Column(name = "estimated_delivery_days")
    private Integer estimatedDeliveryDays = 3;

    @Enumerated(EnumType.STRING)
    @Column(name = "shoe_status",nullable = false)
    private ShoeStatus shoeStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status",nullable = false)
    private ApprovalStatus approvalStatus;

    @Column(name = "rejection_reason", length = 200)
    private String rejectionReason;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // 승인하는 관리자 아이디에 해당되는 것
    private User ApprovedBy;

    @Builder.Default
    @Column(name = "approved_at",nullable = false) // 승인날짜
    private LocalDateTime approvedAt;

    @Builder.Default
    @Column(name = "is_active",nullable = false) // 활성화여부
    private Boolean isActive = false;

    @Builder.Default
    @Column(name = "is_featured") // 추천상품,일반상품
    private Boolean isFeatured = false;

    @Builder.Default
    @Column(name = "is_new_arrival")
    private Boolean isNewArrival=false;

    @Builder.Default
    @Column(name="display_start_date",nullable = false) // 생성 및 업데이트 날짜로 자동생성, 오늘 이후 날짜만 가능
    private LocalDateTime displayStartDate;

    @Builder.Default
    @Column(name="display_end_date",nullable = false) // 시작일 + 30일, 시작일 이후 날짜만 선택 가능
    private LocalDateTime displayEndDate;

    @Version // 낙관적 락, 동시성 문제 방지용(동시 수정 시에 충돌 방지용)
    @Column(name = "version")
    private Integer version;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public void markDeleted() {
        this.deletedAt = LocalDateTime.now();
    }


}
