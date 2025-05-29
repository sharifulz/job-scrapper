package com.scrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scrapper.service.GoogleSearchSeleniumService;
import com.scrapper.service.ScraperService;

@RestController
@RequestMapping("/api/scrape")
public class ScraperController {

	@Autowired
    private ScraperService scraperService;
    
	@Autowired
    private GoogleSearchSeleniumService searchService;


    //http://localhost:8088/api/scrape?query=java+web+scraping&pages=2
    @GetMapping
    public List<String> scrape(@RequestParam("query") String query,@RequestParam(name = "pages", defaultValue = "1") int pages) {
    	System.out.println("----------------- API Called -----------------");
        return scraperService.scrapeGoogleResults(query, pages);
    }
    
    //http://localhost:8088/api/scrape/download?query=java+web+scraping
    @GetMapping("/download")
    public ResponseEntity<String> download(@RequestParam("query") String query) {
        String filePath = "google_selenium_result.html";
        String result = searchService.downloadSearchHtml(query, filePath);
        return ResponseEntity.ok(result);
    }
}

