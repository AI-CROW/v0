package com.crow.crow.article;

import com.crow.crow.scraper.sites.core.Coindesk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    private final ArticleService articleService;
    private final Coindesk coindesk;

    @Autowired
    public ArticleController(ArticleService articleService, Coindesk coindesk) {
        this.articleService = articleService;
        this.coindesk = coindesk;
    }

    @RequestMapping("api/article")
    @PostMapping
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }

    @RequestMapping("api/articles")
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @RequestMapping("api/articles/update")
    @GetMapping
    public void updateArticles() {
        coindesk.update();
    }

    @RequestMapping("api/articles/{x}/{y}")
    @GetMapping
    public List<Article> getArticlesByX(@PathVariable("x") String x, @PathVariable("y") String y) {
        return articleService.getArticlesByX(x, y);
    }
}