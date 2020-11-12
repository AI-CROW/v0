package com.crow.crow.scraper;

import com.crow.crow.article.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class WebScraper {

    private final ArticleDao articleDao;

    @Autowired
    public WebScraper(@Qualifier("postgres")ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

//    public List<Site> scrapeAll() {
////        Loop through all sites in site table
////        Call every sites scrape function from core and contrib
////        Add all articles to database
//    }
}
