package com.uptc.layers.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "two_value_scale")
public class TwoValueScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<TwoValueResponse> response;

    private Float trueOptionValue;
    private Float falseOptionValue;

    public Long getId() {
        return id;
    }
    public Set<TwoValueResponse> getResponse() {
        return response;
    }
    public Float getTrueOptionValue() {
        return trueOptionValue;
    }
    public Float getFalseOptionValue() {
        return falseOptionValue;
    }
}
