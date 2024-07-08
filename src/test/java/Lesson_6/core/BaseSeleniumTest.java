package Lesson_6.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

// 1. Create a Maven project (Java) using the listed libraries
abstract public class BaseSeleniumTest {
//    WebDriverManager webDriverManager = new WebDriverManager();
//    WebDriver driver = webDriverManager.getDriver();
    private static final Logger logger = LogManager.getLogger(Lesson_6.utils.WebDriverManager.class);
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        BaseSeleniumPage.setDriver(driver);
        logger.info("ChromeDriver инициализирован");

    }

    @AfterEach
    public void tearDown() {
        driver.close();
        logger.info("Браузер закрыт");
        driver.quit();

    }
}
