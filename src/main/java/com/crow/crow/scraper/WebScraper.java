package com.crow.crow.scraper;

import com.crow.crow.article.Article;
import com.crow.crow.article.ArticleDao;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class WebScraper {

    private static final List<String> baseUrls = Arrays.asList("https://www.coindesk.com/category/markets");
    private static ArrayList<Article> articles;

    private final ArticleDao articleDao;

    @Autowired
    public WebScraper(@Qualifier("postgres")ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    private List<Article> scrape() {

        WebClient client = new WebClient();
        client.getOptions().setJavaScriptEnabled(false);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setUseInsecureSSL(false);

        for (String baseUrl : baseUrls) {
            try {
                HtmlPage page = client.getPage(baseUrl);
                List<HtmlElement> htmlArticles = page.getByXPath("//div[@class='list-item-wrapper']");
                if (htmlArticles.isEmpty()) {
                    System.out.println("No articles");
                }
                else {
                    articles = new ArrayList<Article>();
                    for (HtmlElement htmlArticle : htmlArticles) {
                        HtmlAnchor articleAnchor = ((HtmlAnchor) htmlArticle.getFirstByXPath(".//h4[@class='heading']/parent::a"));
                        HtmlElement articleAuthor = htmlArticle.getFirstByXPath(".//span[@class='credit']");
                        HtmlElement articleDate = htmlArticle.getFirstByXPath(".//time[@class='time']");

                        String title = articleAnchor.asText();
                        String author = articleAuthor.asText();
                        String postDate = articleDate.asText();
                        String url = "https://coindesk.com" + articleAnchor.getHrefAttribute();
                        Article article = new Article(UUID.randomUUID(), title, author, postDate, "", url);

                        articles.add(article);
                    }

                    for (Article article : articles) {
                        page = client.getPage(article.getUrl());
                        String content = "";
                        int counter = 0;
                        boolean nodeExists = true;

                        while (nodeExists) {
                            String queryString = "//div[@id='node-" + counter + "']";
                            HtmlElement node = page.getFirstByXPath(queryString);

                            try {
                                content += " " + node.asText();
                            } catch (NullPointerException e) {
//                                e.printStackTrace();
                                nodeExists = false;
                                article.setContent(content);
                                content = "";
                            }
                            counter++;
                        }
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return articles;
    }

    public void update() {
        List<Article> articles = scrape();

        for (Article article : articles) {
            System.out.println("Title: " + article.getTitle());
            System.out.println("Author: " + article.getAuthor());
            System.out.println("Post Date: " + article.getPostDate());
            System.out.println("Link: " + article.getUrl());
            System.out.println("Content: " + article.getContent());
            System.out.println("-------------------------------------");
        }

        for (Article article : articles) {
            articleDao.insertArticle(article);
        }
    }
}