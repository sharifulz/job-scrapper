package com.scrapper.service;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

@Service
public class GoogleSearchSeleniumService {

    public String downloadSearchHtml(String query, String outputFilePath) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run without GUI
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);

        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String url = "https://www.google.com/search?q=" + encodedQuery;
            driver.get(url);

            Thread.sleep(3000); // wait for JS to load

            String pageSource = driver.getPageSource();

            try (FileWriter writer = new FileWriter(outputFilePath)) {
                writer.write(pageSource);
            }

            return "HTML saved to " + outputFilePath;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        } finally {
            driver.quit();
        }
    }
}

