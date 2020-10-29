# Crypto Project

## Metadata

- Name: Crow
- Author: Ian Koide
- Start Date: 10/6/20
- Languages: Java, Python, HTML, CSS, SCSS, JS
- Java Version: 1.8 (8)
- Framework: Spring Boot
- Purpose: Give an estimate of a projected cryptocurrency (Bitcoin) price based on data gathered from multiple cryptocurrency news sources using machine learning and other various computer algorithms.

## TODO

- Setup webserver with cronjob to query all websites for articles every day, then add them to the database for the model to use
- Organize all data with a modern UI
- Add API to allow people to query our website for cryptocurrency prices, our predictions and articles
- Add feature/ api for cryptocurrency news sites to get their articles added to the algorithm pool
- Make it open source in such a manor that contributors can add the necessary files to scrape a site and give the correct data, site data and predictions will not be immediately incorporated into the ML algorithm pool but if predictions serve somewhat accurate then it will be added to the pool.

## Process I. (Web Scraping for Articles)

1. Gather list of urls that posts bitcoin news
2. Parse all sites for recent articles
3. Parse recent articles for data
4. Store data in a database

## Process II. (NLP Data Gathering)

### Goals

- Find price prediction of author
- What is the author saying

## Process III. (AI Algorithm Predictions)

1. Remove all posts that aren't predicting the price

### Process IV. (Was the Algorithm Right)

## Process V. (Displaying Data)

1. Display data on a webpage

### How is post accuracy determined

- Were previous articles by this author right?
    - How close were the predictions to the actual price during the specified time?
- How much research went into this article?
- Are others posting similar price predictions?
    - How reputable are the others who are posting similar predictions?
- Is the prediction from a reputable source?
    - Can anyone post an article on this source?
    - How accurate have other articles from this source been?

### Model

#### What is the desired result of the model?

- Is the price prediction right?
- What is the article saying about bitcoin and cryptocurrency in general?

Instead of just checking a price prediction with the future price. Interpreting what the article is saying about XBT
and crypto in general, we can assign a value on a scale for the article.

##### What must go into the process?

- Is the article stating facts or opinions?

#### Model Variables

- Accuracy of previous posts by author

### Organization of data

- All posts have a relationship with the website
- There is a total website credibility and author credibility

### Research Links

- https://www.javatpoint.com/nlp
- https://www.youtube.com/watch?v=35EQXmHKZYs 27:18