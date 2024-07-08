package Lesson_6.demoQa;


import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import Lesson_6.utils.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;

//import static Lesson_6.core.BaseSeleniumPage.driver;

/**
 * Главная страница сайта demoqa.com
 */

public class MainPage extends BaseSeleniumPage {

    private static final Logger logger = LogManager.getLogger(MainPage.class);
    public MainPage(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
        logger.info("Открыта страница: " + ConfigProvider.URL);
    }

//    WebDriverManager webDriverManager = new WebDriverManager();
//    WebDriver driver = webDriverManager.getDriver();


    @FindBy(xpath = "//div[@class='category-cards']")
    private WebElement categoryCards;

    @FindBy(xpath = "//div[@class='card mt-4 top-card'][1]")
    private WebElement elements;



        public String returnCard(){
       return categoryCards.getText();
    }

    public void clickOnElements() {
        elements.click(); logger.info("Клик по элементу выполнен"); // вынести в отдельный класс, так как не везде нужны;
    }

//    public String getElementAttr(){
//       return elements.getText();
//    }

// +   private final By categoryCards = By.xpath("//div[@class='category-cards']");

//  +  private final ElementsCollection categoryCards = $$x("//div[@class='category-cards']");
//
//    private final SelenideElement elementsButton = $x("//a[@href='https://ultimateqa.com/consulting/']");
//
//    private final SelenideElement elements = $x("//div[@class='card mt-4 top-card']");

//тут вызываются все элементы на странице, но если какой-то элемент появится позже, то будут проблемы
//    private WebElement queueListElements = driver.findElement(categoryCards);



//    public MainPage(String url){
//        Selenide.open(url);
//    }
//

//
//    public void clicOnElement(){
//        elementsButton.click(); // но этого этапа мало. Для начала нам надо откоыть браузер и открыт страницу
//    }
//

//
//
//    public ElementsCollection getCategoryCards() {
//        return categoryCards;
//    }
//
//    public SelenideElement getElementsButton() {
//        return elementsButton;
//    }
//
//    public SelenideElement getElements() {
//        return elements;
//    }
}
