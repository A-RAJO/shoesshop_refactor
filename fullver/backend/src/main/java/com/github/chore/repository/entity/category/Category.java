package com.github.chore.repository.entity.category;

import jakarta.persistence.*;
import lombok.*;

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
    private String targetGender;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_group", nullable = false)
    private ageGroup ageGroup;




}
