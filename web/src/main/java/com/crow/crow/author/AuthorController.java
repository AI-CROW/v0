package com.crow.crow.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("api/authors")
    @GetMapping
    public List<Author> getAllAuthors() { return authorService.getAllAuthors(); }

    @RequestMapping("api/authors/{x}/{y}")
    @GetMapping
    public List<Author> getAuthorsByX(@PathVariable("x") String x, @PathVariable("y") String y) {
        return authorService.getAuthorsByX(x, y);
    }
}
