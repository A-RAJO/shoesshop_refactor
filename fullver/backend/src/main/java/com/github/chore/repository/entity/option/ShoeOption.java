package com.github.chore.repository.entity.option;

import jakarta.persistence.*;

@Entity
@Table(name = "shoe_option")
public class ShoeOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoe_option_id", nullable = false)
    private Integer shoe_option_id;

}
