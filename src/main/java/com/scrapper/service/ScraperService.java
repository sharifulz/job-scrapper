package com.scrapper.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScraperService {

    //private static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=%s&start=%d";

    private static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=java+learn";

    public List<String> scrapeGoogleResults(String query, int pages) {
        List<String> results = new ArrayList<>();

        try {
            for (int i = 0; i < pages; i++) {
                String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
                String url = String.format(GOOGLE_SEARCH_URL, encodedQuery, i * 10);

                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                        .timeout(10 * 1000)
                        .get();

                System.out.println("Response: "+ doc);
                Elements searchResults = doc.select("div.g"); // Main result blocks

                for (Element result : searchResults) {
                    Element link = result.selectFirst("a");
                    if (link != null) {
                        String href = link.absUrl("href");
                        if (!href.isEmpty()) {
                            results.add(href);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }
}

