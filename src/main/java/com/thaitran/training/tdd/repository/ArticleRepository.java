package com.thaitran.training.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thaitran.training.tdd.bean.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
