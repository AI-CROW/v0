# CROW AI

## Metadata

- Name: Crow AI
- Author: Ian Koide
- Start Date: 10/6/20
- Languages: Java, Python, HTML, CSS/SCSS, JS
- Java Version: 1.8 (8)
- Framework: Spring Boot
- Purpose: Give an estimate of a projected cryptocurrency (Bitcoin) price based on data gathered from multiple cryptocurrency news sources using machine learning and other various computer algorithms.

## Process

### I. (Initial Site Parsing Implementation)

The server will first parse the core and contrib packages for valid site classes, execute their code, and then append the data to the database. This data is also available to be viewed in the json and raw formatting via our [API](https://crow-ai.readthedocs.io/en/latest/).

Sites can be added into the model by creating the properly formatted class for each site. Learn more about adding a site [here](https://crow-ai.readthedocs.io/en/latest/).

### II. (NLP Data Structuring)

All data scraped will then be sequenced by an NLP algorithm to search for useful information, such as the authors prediction of future cryptocurrency prices, the authors opinions on relevant matters and more.

For more information on our NLP algorithm head [here](https://crow-ai.readthedocs.io/en/latest/).

### III. (AI Algorithm Predictions)

1. Remove all posts that aren't predicting the price

### IV. (Was the Algorithm Right)

### V. (Displaying Data)

1. Display data on a webpage

#### How is post accuracy determined

- Were previous articles by this author right?
    - How close were the predictions to the actual price during the specified time?
- How much research went into this article?
- Are others posting similar price predictions?
    - How reputable are the others who are posting similar predictions?
- Is the prediction from a reputable source?
    - Can anyone post an article on this source?
    - How accurate have other articles from this source been?

## Model

### What is the desired result of the model?

- Is the price prediction right?
- What is the article saying about bitcoin and cryptocurrency in general?

Instead of just checking a price prediction with the future price. Interpreting what the article is saying about XBT
and crypto in general, we can assign a value on a scale for the article.

#### What must go into the process?

- Is the article stating facts or opinions?

### Model Variables

- Accuracy of previous posts by author

## Organization of data

- All posts have a relationship with the website
- There is a total website credibility and author credibility

## Research Links

- https://www.javatpoint.com/nlp
- https://www.youtube.com/watch?v=35EQXmHKZYs 27:18