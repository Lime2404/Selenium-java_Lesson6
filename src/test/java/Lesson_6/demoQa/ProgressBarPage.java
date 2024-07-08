package Lesson_6.demoQa;


import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProgressBarPage extends BaseSeleniumPage {
    private static final Logger logger = LogManager.getLogger(MainPage.class);

    public ProgressBarPage(){
        driver.get(ConfigProvider.URL+"progress-bar");
        PageFactory.initElements(driver, this);
        logger.info("Открыта страница: " + ConfigProvider.URL+"progress-bar");
    }

    @FindBy(xpath = "//div[@class=\"progress-bar bg-info\"]")
    private WebElement progressBarElement;
    // заменить на селенид Элемента

    @FindBy(xpath = "//div[@class=\"progress-bar bg-info\"]")
    private WebElement progressBarSuccess;

    @FindBy(xpath = "//button[@class=\"mt-3 btn btn-primary\"]")
    private WebElement startButton;

    @FindBy(xpath = "//button[@class=\"mt-3 btn btn-primary\"]")
    private WebElement resetButton;

//    private final WebElement progressBar =  $x("//div[@class=\"progress-bar bg-info\"]");
//    private final WebElement progressBarElement =  $x("//div[@class=\"progress-bar bg-info\"]");
//    private final WebElement progressBarSuccess =  $x("//div[@class=\"progress-bar bg-success\"]");
//    private final WebElement startButton = $x("//button[@class=\"mt-3 btn btn-primary\"]");
//    private final WebElement resetButton = $x("//button[@class=\"mt-3 btn btn-primary\"]");
////button[contains(@class, 'mt-3 btn btn-primary' ) and contains(@id, 'resetButton') and contains(@type, 'button')]




//    public ProgressBarPage(String url){
//        Selenide.open(url);
//    }

    public void clickStartButton(){ startButton.click(); logger.info("Клик по кнопке Start выполнен"); }

    public String getAreaValue(){ return progressBarElement.getAttribute("aria-valuenow");}

    public String getAreaSuccessValue(){ return progressBarSuccess.getAttribute("aria-valuenow");}

    public String getAriaValueMax(){
        return progressBarElement.getAttribute("aria-valuemax");
    }

    public WebElement getStartButton(){ return startButton; }

    public WebElement getResetButton() {
        return resetButton;
    }



    public void clickResetButton(){
        progressBarElement.click();
    }



}
