package com.uptc.layers.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "four_value_scale")
public class FourValueScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<FourValueResponse> response;

    private Float firstOptionValue;
    private Float secondOptionValue;
    private Float thirdOptionValue;
    private Float fourthOptionValue;
}
