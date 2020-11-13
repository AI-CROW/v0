package com.crow.crow.scraper;

import com.crow.crow.site.Site;
import com.crow.crow.site.SiteDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebScraper {

    private final SiteDataAccessService siteDataAccessService;

    @Autowired
    public WebScraper(SiteDataAccessService siteDataAccessService) {
        this.siteDataAccessService = siteDataAccessService;
    }

    public List<Site> scrapeAll() {
//        Grab all sites from database
//        Loop through all sites in site table
//        Call every sites scrape function from core and contrib
//        Add all articles to database

        List<Site> sites = siteDataAccessService.selectAllSites();

        for (Site site : sites) {
//            String importName = "com.crow.crow.scraper.sites.core." + site.getName();
//            import importName;
            
        }

        return sites;
    }
}
