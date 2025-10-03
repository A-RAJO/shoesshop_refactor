package com.github.chore.repository.entity.seller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "seller_profile")
@Entity
public class Seller {
    @Id
    @Column(name = "seller_id",nullable = false)
    private Integer seller;
}
