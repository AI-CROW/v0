package com.crow.crow.scraper;

import com.crow.crow.article.Article;
import com.crow.crow.article.ArticleDataAccessService;
import com.crow.crow.author.Author;
import com.crow.crow.author.AuthorDataAccessService;
import com.crow.crow.site.Site;
import com.crow.crow.site.SiteDataAccessService;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

@Component
public class WebScraper {

    private final SiteDataAccessService siteDataAccessService;
    private final ArticleDataAccessService articleDataAccessService;
    private final AuthorDataAccessService authorDataAccessService;

    public WebScraper(SiteDataAccessService siteDataAccessService, ArticleDataAccessService articleDataAccessService, AuthorDataAccessService authorDataAccessService) {
        this.siteDataAccessService = siteDataAccessService;
        this.articleDataAccessService = articleDataAccessService;
        this.authorDataAccessService = authorDataAccessService;
    }

    private WebClient connect() {

        WebClient client = new WebClient();
        client.getOptions().setJavaScriptEnabled(false);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setUseInsecureSSL(false);

        return client;
    }

    @Scheduled(cron = "0 */5 * * * *")
    public List<Site> scrapeAll() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        List<Site> sites = siteDataAccessService.selectAllSites();
        WebClient client = connect();

        for (Site site : sites) {
            String classPath = "com.crow.crow.scraper.sites.core." + site.getName();
            Class siteClass = Class.forName(classPath);
            Method siteMethod = siteClass.getMethod("scrape", WebClient.class);
            Object o = siteMethod.invoke(null, client);
            List<Article> articles = (List<Article>) o;

            for (Article article : articles) {
                Author author = new Author(UUID.randomUUID(), article.getAuthor(), 0.00);

                List<Author> authorQuery = authorDataAccessService.getAuthorsByX("name", author.getName());

                try {
                    if (authorQuery.get(0).getName().equals(author.getName())) {
                        article.setAuthor_id(authorQuery.get(0).getId());
                    }
                    else {
                        authorDataAccessService.insertAuthor(author.getId(), author);
                        article.setAuthor_id(author.getId());
                    }
                } catch (IndexOutOfBoundsException e) {
                    authorDataAccessService.insertAuthor(author.getId(), author);
                    article.setAuthor_id(author.getId());
                }

                List<Site> siteQuery = siteDataAccessService.getSitesByX("name", site.getName());

                article.setSite_id(siteQuery.get(0).getId());

                if (!articleDataAccessService.exists(article.getTitle())) {
                    articleDataAccessService.insertArticle(article);
                }
            }
        }
        System.out.println("test");

        return sites;
    }
}