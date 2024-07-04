package Lesson_6.demoQa;

import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BaseSeleniumPage {

    @FindBy(xpath = "//ul[@class='menu-list']")
    private WebElement elementsList;

//    private final WebElement message = $x("//div[@id='Ad.Plus-970x250-1']/../text()");
//    private final ElementsCollection elementsList = $$x("//ul[@class='menu-list']");
public ElementsPage(){
    driver.get(ConfigProvider.URL);
    PageFactory.initElements(driver, this);
}

    public WebElement getElementsList() {
        return elementsList;
    }

//    public WebElement getElements(){
//        return elementsList.first();
//    }
}