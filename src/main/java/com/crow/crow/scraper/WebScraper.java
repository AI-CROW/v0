package com.crow.crow.scraper;

import com.crow.crow.article.ArticleDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class WebScraper {

    private final ArticleDataAccessService articleDataAccessService;

    @Autowired
    public WebScraper(@Qualifier("postgres")ArticleDataAccessService articleDataAccessService) {
        this.articleDataAccessService = articleDataAccessService;
    }

//    public List<Site> scrapeAll() {
////        Loop through all sites in site table
////        Call every sites scrape function from core and contrib
////        Add all articles to database
//    }
}
