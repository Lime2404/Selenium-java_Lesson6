//package Lesson_6.utils;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class WebDriverManager {
//    private static final Logger logger = LogManager.getLogger(WebDriverManager.class);
//    private WebDriver driver;
//
//    public WebDriverManager() {
//        driver = new ChromeDriver();
//        logger.info("ChromeDriver инициализирован");
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
//
//    public void openUrl(String url) {
//        driver.get(url);
//        logger.info("Открыта страница: " + url);
//    }
//
//    public void quit() {
//        if (driver != null) {
//            driver.quit();
//            logger.info("Браузер закрыт");
//        }
//    }
//}
