package com.thaitran.training.tdd.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.thaitran.training.tdd.bean.Article;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleRepositoryTest {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void findArticleById_returnArticleInfo() {
        Article saveArticle = entityManager.persistAndFlush(new Article(1L));

        Optional<Article> articleOptional =  articleRepository.findById(1L);
        Assertions.assertThat(articleOptional.get().getId()).isEqualTo(saveArticle.getId());
    }
}
