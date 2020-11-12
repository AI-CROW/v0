package com.crow.crow.article;

import com.crow.crow.scraper.WebScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    private final ArticleService articleService;
    private final WebScraper webScraper;

    @Autowired
    public ArticleController(ArticleService articleService, WebScraper webScraper) {
        this.articleService = articleService;
        this.webScraper = webScraper;
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
        webScraper.update();
    }

    @RequestMapping("api/articles/{x}/{y}")
    @GetMapping
    public List<Article> getArticlesByX(@PathVariable("x") String x, @PathVariable("y") String y) {
        return articleService.getArticlesByX(x, y);
    }
}