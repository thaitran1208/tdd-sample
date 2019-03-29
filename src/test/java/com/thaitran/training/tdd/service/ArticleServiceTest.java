package com.thaitran.training.tdd.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.thaitran.training.tdd.bean.Article;
import com.thaitran.training.tdd.exception.ArticleNotFoundException;
import com.thaitran.training.tdd.repository.ArticleRepository;

@RunWith(SpringRunner.class)
public class ArticleServiceTest {
    @Mock
    ArticleRepository articleRepository;

    private ArticleService articleService;

    @Before
    public void setUp() {
        articleService = new ArticleService(articleRepository);
    }

    @Test
    public void getArticleDetail_returnArticleInfo() {
        Mockito.when(articleRepository.findById(1L)).thenReturn(Optional.of(new Article(1L)));
        Article article = articleService.getArticle(1L);

        Assertions.assertThat(article.getId()).isEqualTo(1L);
    }

    @Test(expected = ArticleNotFoundException.class)
    public void getArticleDetail_throwArticleNotFoundException() {
        Mockito.when(articleRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Article article = articleService.getArticle(Mockito.anyLong());
    }
}
