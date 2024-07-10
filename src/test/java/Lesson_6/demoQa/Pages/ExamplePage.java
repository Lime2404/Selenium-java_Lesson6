package Lesson_6.demoQa.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExamplePage {
    private static final Logger logger = LogManager.getLogger(ExamplePage.class);
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='card mt-4 top-card'][1]")
    private WebElement elements;

    public ExamplePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("Страница инициализирована");
    }

    public void clickOnElements() {
        elements.click();
        logger.info("Клик по элементу выполнен");
    }
}
