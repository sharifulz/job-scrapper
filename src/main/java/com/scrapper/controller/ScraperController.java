package com.scrapper.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scrapper.service.ScraperService;

@RestController
@RequestMapping("/api/scrape")
public class ScraperController {

    private final ScraperService scraperService;

    public ScraperController(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    //http://localhost:8088/api/scrape?query=java+web+scraping&pages=2
    @GetMapping
    public List<String> scrape(@RequestParam("query") String query,@RequestParam(name = "pages", defaultValue = "1") int pages) {
    	System.out.println("----------------- API Called -----------------");
        return scraperService.scrapeGoogleResults(query, pages);
    }
}

