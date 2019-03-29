package com.thaitran.training.tdd.bean;

public class Article {
    private Long id;
    public Article(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
