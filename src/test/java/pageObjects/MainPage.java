package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница сайта demoqa.com
 */

public class MainPage {

    private final ElementsCollection categoryCards = $$x("//div[@class='category-cards']");

    private final SelenideElement elementsButton = $x("//a[@href='https://ultimateqa.com/consulting/']");

    private final SelenideElement elements = $x("//div[@class='card mt-4 top-card']");

    public MainPage(String url){
        Selenide.open(url);
    }

public void clicOnElements(){

    // вынести в отдельный класс, так как не везде нужны
    elements.click(); // но этого этапа мало. Для начала нам надо откоыть браузер и открыт страницу
}

    public void clicOnElement(){
        elementsButton.click(); // но этого этапа мало. Для начала нам надо откоыть браузер и открыт страницу
    }

    public String returnCard(){
       return categoryCards.first().getText();
    }


    public ElementsCollection getCategoryCards() {
        return categoryCards;
    }

    public SelenideElement getElementsButton() {
        return elementsButton;
    }

    public SelenideElement getElements() {
        return elements;
    }
}
