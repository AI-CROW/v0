package com.crow.crow;

import com.crow.crow.model.Article;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CrowApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CrowApplication.class, args);

		Article a = context.getBean(Article.class);

		a.show();
	}

}
