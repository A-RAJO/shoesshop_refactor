package com.github.chore.repository.entity.category;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "category_name",nullable = false, length = 100)
    private String categoryName;

    @OneToOne
    @JoinColumn(name="category",nullable = false)
    private Category parentCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "targer_gender", nullable = false)
    private targetGender targetGender;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_group", nullable = false)
    private ageGroup ageGroup;

    @Enumerated(EnumType.STRING)
    @Column(name="shoe_type",nullable = false)
    private shoeType shoeType;

    @Column(name="cotegory_level")
    private Integer categoryLevel;

    @Column(name = "category_path",length = 500)
    private String categoryPath;

    @OneToOne
    @JoinColumn(name = "category")
    private Category category;

    @Column(name = "created_at", nullable = false, updatable = false) // 자동 입력 기능 필요 : @LastModifiedDate와 Auditing 설정
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
