package com.crow.crow.scraper.sites.core;

import com.crow.crow.article.Article;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Coindesk {

    private static ArrayList<String> baseUrls = new ArrayList<>(Arrays.asList(
            "https://www.coindesk.com/category/markets",
            "https://www.coindesk.com/tag/markets-bitcoin",
            "https://www.coindesk.com/tag/ethereum"
    ));
    private static ArrayList<Article> articles;

    public static List<Article> scrape(WebClient client) {
        try {
            for (String baseUrl : baseUrls) {
                HtmlPage page = client.getPage(baseUrl);
                List<HtmlElement> htmlArticles = page.getByXPath("//div[@class='list-item-wrapper']");
                try {
                    articles = new ArrayList<Article>();
                    for (HtmlElement htmlArticle : htmlArticles) {
                        HtmlAnchor articleAnchor = ((HtmlAnchor) htmlArticle.getFirstByXPath(".//h4[@class='heading']/parent::a"));
                        HtmlElement articleAuthor = htmlArticle.getFirstByXPath(".//span[@class='credit']");
                        HtmlElement articleDate = htmlArticle.getFirstByXPath(".//time[@class='time']");

                        String title = articleAnchor.asText();
                        String author = articleAuthor.asText();
                        String postDate = articleDate.asText();
                        String url = "https://coindesk.com" + articleAnchor.getHrefAttribute();

                        Article article = new Article(UUID.randomUUID(), title, author, postDate, null, url, null, null);

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
                                nodeExists = false;
                                article.setContent(content);
                                content = "";
                            }
                            counter++;
                        }
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            return null;
        }
        return articles;
    }
}