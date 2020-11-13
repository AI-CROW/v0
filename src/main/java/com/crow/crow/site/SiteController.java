package com.crow.crow.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SiteController {

    private final SiteService siteService;

    @Autowired
    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @RequestMapping("api/sites")
    @GetMapping
    public List<Site> getAllSites() { return siteService.getAllSites(); }

    @RequestMapping("api/sites/{x}/{y}")
    @GetMapping
    public List<Site> getSitesByX(@PathVariable("x") String x, @PathVariable("y") String y) {
        return siteService.getSitesByX(x, y);
    }
}
