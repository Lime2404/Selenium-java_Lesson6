package Lesson_6.demoQa.Pages;

import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class MainPage extends BaseSeleniumPage {

    private static final Logger logger = LogManager.getLogger(MainPage.class);
    public MainPage(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
        logger.info("The page " + ConfigProvider.URL + " has been opened");
    }

    @FindBy(xpath = "//div[@class='category-cards']")
    private WebElement categoryCards;

    @FindBy(xpath = "//div[@class='card mt-4 top-card'][1]")
    private WebElement elements;

    @FindBy(id = "adplus-anchor")
    private WebElement adplusAnchor;

    public String returnCard(){
    return categoryCards.getText();
    }

    public void clickOnElements() {

//        WebElement element = scrollUntilElementVisible(driver, "//div[@class='card mt-4 top-card'][1]");
//        if (element != null) {
//            System.out.println("Element is visible.");
            elements.click();
            logger.info("The element has been clicked"); // вынести в отдельный класс, так как не везде нужны;
//        }
    }
// attempting to scroll down to make sure element is visible and clickable
        public static WebElement scrollUntilElementVisible(WebDriver driver, String xpath) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(03)); // Настройте таймаут ожидания
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean isVisible = false;
            WebElement element = null;

            while (!isVisible) {
                try {
                    element = driver.findElement(By.xpath(xpath));
                    isVisible = element.isDisplayed();
                } catch (Exception e) {
                    isVisible = false;
                }

                if (!isVisible) {
                    js.executeScript("window.scrollBy(0, 250);"); // Прокрутите на 250 пикселей вниз
                    try {
                        Thread.sleep(500); // Задержка, чтобы дать странице время для загрузки
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            return element;
        }

//    public void hideAds(){
//        if (adplusAnchor.isDisplayed()) {
//            adplusAnchor.sendKeys(Keys.DOWN);
//        }
//    }
    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Прокрутите на 1000 пикселей вниз
        js.executeScript("window.scrollBy(0, 1000);");
    }
}
