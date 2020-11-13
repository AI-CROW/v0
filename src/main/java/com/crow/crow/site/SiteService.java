package com.crow.crow.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    private final SiteDataAccessService siteDataAccessService;

    @Autowired
    public SiteService(SiteDataAccessService siteDataAccessService) {
        this.siteDataAccessService = siteDataAccessService;
    }

    public List<Site> getAllSites() { return siteDataAccessService.selectAllSites(); }
    public List<Site> getSitesByX(String x, String y) { return siteDataAccessService.getSitesByX(x, y); }
}
