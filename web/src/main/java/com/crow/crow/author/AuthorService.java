package com.crow.crow.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorDataAccessService authorDataAccessService;

    @Autowired
    public AuthorService(AuthorDataAccessService authorDataAccessService) {
        this.authorDataAccessService = authorDataAccessService;
    }

    public List<Author> getAllAuthors() { return authorDataAccessService.selectAllAuthors(); }
    public List<Author> getAuthorsByX(String x, String y) { return authorDataAccessService.getAuthorsByX(x, y); }
}
