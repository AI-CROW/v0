package com.crow.crow.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("api/articles")
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @RequestMapping("api/articles/{x}/{y}")
    @GetMapping
    public List<Article> getArticlesByX(@PathVariable("x") String x, @PathVariable("y") String y) {
        return articleService.getArticlesByX(x, y);
    }
}