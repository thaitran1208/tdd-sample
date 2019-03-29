package com.thaitran.training.tdd.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thaitran.training.tdd.bean.Article;
import com.thaitran.training.tdd.exception.ArticleNotFoundException;
import com.thaitran.training.tdd.repository.ArticleRepository;

@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    public Article getArticle(Long id) {
        Optional<Article> articleOptional = articleRepository.findById(id);

        if (articleOptional.isPresent()) {
            return articleOptional.get();
        } else {
            throw new ArticleNotFoundException();
        }
    }
}
