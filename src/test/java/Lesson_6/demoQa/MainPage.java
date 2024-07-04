package Lesson_6.demoQa;


import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import static Lesson_6.core.BaseSeleniumPage.driver;

/**
 * Главная страница сайта demoqa.com
 */

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//div[@class='category-cards']")
    private WebElement categoryCards;

    @FindBy(xpath = "//div[@class='card mt-4 top-card']")
    private WebElement elements;

    public MainPage(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

        public String returnCard(){
       return categoryCards.getText();
    }

//    public void clicOnElements() {
//
//        elements.click(); // вынести в отдельный класс, так как не везде нужны;
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
