# Java Web Scraper

This is a Java-based web scraping project built using **Spring Boot 3.5.0** and **Java 21**. It uses popular scraping libraries such as **JSoup**, **Selenium**, and other Java web crawling tools to extract useful information from websites.

## 🔍 Features

- Web scraping using JSoup (HTML parsing)
- Dynamic page scraping using Selenium WebDriver
- Configurable web crawler support
- Spring Boot-based structure with dependency injection and configuration support
- Outputs data in a structured format (e.g., JSON, CSV, or database)

## 🚀 Technologies Used

- **Java 21**
- **Spring Boot 3.5.0**
- **Maven** (for project build)
- **JSoup** (for HTML parsing)
- **Selenium WebDriver** (for dynamic content scraping)
- **Lombok** (optional, for boilerplate reduction)

## 📁 Project Structure

```
java-web-scraper/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/scraper/
│       │       ├── ScraperApplication.java
│       │       ├── service/
│       │       │   ├── JsoupScraperService.java
│       │       │   └── SeleniumScraperService.java
│       │       └── model/
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.txt
```

## 🛠️ Getting Started

### Prerequisites

- Java 21
- Maven 3.8+

### Build and Run

```bash
# Clone the repository
git clone https://github.com/yourusername/java-web-scraper.git
cd java-web-scraper

# Build the project
mvn clean install

# Run the application
java -jar target/java-web-scraper-0.0.1-SNAPSHOT.jar
```

## 🧪 Example Usage

```java
@Autowired
private JsoupScraperService jsoupScraperService;

public void scrape() {
    String url = "https://example.com";
    List<DataItem> items = jsoupScraperService.scrapePage(url);
    items.forEach(System.out::println);
}
```

## 🧰 Configuration

You can configure the scraping targets in `application.properties`:

```properties
scraper.target.url=https://example.com
scraper.useSelenium=true
```

## 📜 License

This project is licensed under the MIT License.

---

Feel free to fork or contribute to improve the capabilities of this web scraper.