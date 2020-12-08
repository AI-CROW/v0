.. _sites:

Source Sites
===============

Source sites are publishers of content that CROW scrapes and uses in it's models to create our prediction. Classes in the ``core`` package are publishers that have been in the model for an extended period of time and have proven to provide useful data. Classes in the ``contrib`` package are either recently added by a community member, or have not yet been proven reputable. Both core and contrib files are used within the predictor model at varying weight.

Supported Sites
---------------

**Core**

+------------------------------------+------------------------------------+------------------------------------+------------------------------------+------------------------------------+
| Name                               |  Articles                          |   Accuracy                         | Date Added                         | Consensus Weight Fraction          |
+------------------------------------+------------------------------------+------------------------------------+------------------------------------+------------------------------------+
| `Coindesk <https://coindesk.com>`_ | 0                                  | 0.000                              | 11/12/20                           | 100%                               |
+------------------------------------+------------------------------------+------------------------------------+------------------------------------+------------------------------------+

**Contrib**

+------------------------------------+------------------------------------+------------------------------------+------------------------------------+------------------------------------+
| Name                               |  Articles                          |   Accuracy                         | Date Added                         | Consensus Weight Fraction          |
+------------------------------------+------------------------------------+------------------------------------+------------------------------------+------------------------------------+

Adding Support for a Site
-------------------------

Want to add a site to the prediction model pool? First let's determine what a site class should return — a list of articles.

.. code-block:: java

    package com.crow.crow.scraper.sites.core;

    import com.crow.crow.article.Article;
    import com.gargoylesoftware.htmlunit.WebClient;
    import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
    import com.gargoylesoftware.htmlunit.html.HtmlElement;
    import com.gargoylesoftware.htmlunit.html.HtmlPage;
    import org.springframework.stereotype.Service;

    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.UUID;

    @Service
    public class Coindesk {

        private static final String baseUrl = "https://www.coindesk.com/category/markets";
        private static ArrayList<Article> articles;

        public static List<Article> scrape(WebClient client) {
            try {
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
            } catch (IOException e) {
                return null;
            }
            return articles;
        }
    }