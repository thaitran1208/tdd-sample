package com.thaitran.training.tdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thaitran.training.tdd.bean.Article;
import com.thaitran.training.tdd.exception.ArticleNotFoundException;
import com.thaitran.training.tdd.service.ArticleService;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping(value = "/api/v1/article/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id) {
        return new ResponseEntity<>(articleService.getArticle(id), HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void articleNotFoundHandler(ArticleNotFoundException e) {

    }
}
