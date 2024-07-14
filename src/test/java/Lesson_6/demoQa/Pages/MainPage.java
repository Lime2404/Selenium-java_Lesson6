package Lesson_6.demoQa.Pages;

import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BaseSeleniumPage {

    private static final Logger logger = LogManager.getLogger(MainPage.class);

    public MainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
        logger.info("The page " + ConfigProvider.URL + " has been opened");
    }

    @FindBy(xpath = "//div[@class='category-cards']")
    private WebElement categoryCards;

    @FindBy(xpath = "//div[@class='card mt-4 top-card'][1]")
    private WebElement elements;

    public String returnCard() {
        return categoryCards.getText();
    }

    public void clickOnElements() {
        elements.click();
        logger.info("The element has been clicked");
    }
}
