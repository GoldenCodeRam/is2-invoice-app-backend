package com.uptc.layers.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String authors;
    private String director;

    @OneToMany(mappedBy = "assignment")
    private Set<TwoValueResponse> aScales;

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthors() {
        return authors;
    }
    public String getDirector() {
        return director;
    }
}
