package com.crow.crow.scraper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebScraper {

    private static final List<String> baseUrls = Arrays.asList("https://www.coindesk.com/category/markets");
    private static ArrayList<Article> articles;

    public static void main(String[] args) {
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

                        Article article = new Article();
                        article.setTitle(articleAnchor.asText());
                        article.setAuthor(articleAuthor.asText());
                        article.setPostDate(articleDate.asText());
                        article.setUrl("https://coindesk.com" + articleAnchor.getHrefAttribute());

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

//                  For testing purposes
                    for (Article article : articles) {
                        System.out.println("Title: " + article.getTitle());
                        System.out.println("Author: " + article.getAuthor());
                        System.out.println("Post Date: " + article.getPostDate());
                        System.out.println("Link: " + article.getUrl());
                        System.out.println("Content: " + article.getContent());
                        System.out.println("-------------------------------------");
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}