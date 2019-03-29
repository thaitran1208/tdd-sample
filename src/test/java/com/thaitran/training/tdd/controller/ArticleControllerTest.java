package com.thaitran.training.tdd.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.thaitran.training.tdd.bean.Article;
import com.thaitran.training.tdd.exception.ArticleNotFoundException;
import com.thaitran.training.tdd.service.ArticleService;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Test
    public void getArticle_shoudReturnArticle() throws Exception {
        Mockito.when(articleService.getArticle(1L)).thenReturn(new Article(1L));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/article/1"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("id").value("1"));
    }

    @Test
    public void getArticle_notFound() throws Exception {
        Mockito.when(articleService.getArticle(Mockito.anyLong())).thenThrow(new ArticleNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/article/1"))
               .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
