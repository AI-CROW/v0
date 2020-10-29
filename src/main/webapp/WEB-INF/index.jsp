<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


      <link rel="stylesheet" href="/css/main.css" text="text/css" />
      <link rel="stylesheet" href="/css/fonts.css" text="text/css" />

      <title>Crow - Home</title>
    </head>
    <body>
      <div class="row">
        <div class="col col-6">
          <img src="/img/logo.svg" class="logo-img" />
          <div class="hello-container">
            <h1 id="hello" class="hello">
              Hello!<br>
              I'm CROW
            </h1>
            <p class="description"><span id="description"></span><span class="blink_me">|</span></p>
          </div>
          <ul class="links">
            <li class="link"><a href="#">Prediction Analysis</a></li>
            <li class="link"><a href="#">Technology</a></li>
            <li class="link"><a href="#">Team</a></li>
            <li class="link"><a href="#">Contact</a></li>
          </ul>    
        </div>
        <div class="col col-6">
          <p class="settings-share">Settings ■ Share!</p>
          <div class="prediction-container">
            <h3 class="prediction-date">October 28th, 2020 09:30 EST</h3>
            <h1 class="prediction-price">$16149</h1>
            <h2 class="prediction-points">+3.5</h2>
            <p class="prediction-desc">Formulated by the research of<br>
              <span class="bold">120836</span> cryptocurrency authors and<br>
              enthusiasts.</p>  
          </div>
          <p class="crypto-prices"><span class="xbt">XBT</span> $13,419 ■ <span class="bch">BCH</span> $266 ■ <span class="eth">ETH</span> $404 ■ <span class="xmr">XMR</span> $136</p>
        </div>
      </div>
  
    <script>
      var i = 0;
      function typeWriter(content, elementName, speed) { 
        if (i < this.content.length) {
          document.getElementById(this.elementName).innerHTML += this.content.charAt(i);
          i++;
          setTimeout(typeWriter, this.speed);
        }
      }
  
      typeWriter(content="I predict cryptocurrency prices based on what the public is saying.", elementName="description", speed=35);
    </script>
      </body>
</html>