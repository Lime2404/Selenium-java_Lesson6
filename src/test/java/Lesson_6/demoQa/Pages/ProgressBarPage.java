package Lesson_6.demoQa.Pages;

import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage extends BaseSeleniumPage {
    private static final Logger logger = LogManager.getLogger(MainPage.class);

    public ProgressBarPage() {
        driver.get(ConfigProvider.URL + "progress-bar");
        PageFactory.initElements(driver, this);
        logger.info("The page " + ConfigProvider.URL + "progress-bar" + " has been opened");
    }

//    @FindBy(xpath = "//div[@class=\"progress-bar bg-info\"]")
//    private WebElement progressBarElement;
//    // заменить на селенид Элемента

//    @FindBy(xpath = "//div[@class=\"progress-bar bg-info\"]")
//    private WebElement progressBarSuccess;

    @FindBy(xpath = "//button[@class=\"mt-3 btn btn-primary\"]")
    private WebElement startButton;

//    @FindBy(xpath = "//button[@class=\"mt-3 btn btn-primary\"]")
//    private WebElement resetButton;

    @FindBy(id = "google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0")
    private WebElement adplusAnchor;

    public void clickStartButton() {
        startButton.click();
        logger.info("The Start button has been pressed");
    }

//    public String getAreaValue() {
//        return progressBarElement.getAttribute("aria-valuenow");
//    }

//    public String getAreaSuccessValue() {
//        return progressBarSuccess.getAttribute("aria-valuenow");
//    }

//    public String getAriaValueMax() {
//        return progressBarElement.getAttribute("aria-valuemax");
//    }

    public WebElement getStartButton() {
        return startButton;
    }

//    public WebElement getResetButton() {
//        return resetButton;
//    }

    public void hideAds() {
        if (adplusAnchor.isDisplayed()) {
            adplusAnchor.clear();
        }
    }
}
