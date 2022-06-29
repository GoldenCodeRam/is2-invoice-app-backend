package com.uptc.layers.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="two_value_response")
public class TwoValueResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="assignment_id", nullable=false)
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name="two_value_scale_id", nullable=false)
    private TwoValueScale scale;

    private Boolean response;
}
