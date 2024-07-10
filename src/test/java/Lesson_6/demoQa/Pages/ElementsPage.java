package Lesson_6.demoQa.Pages;

import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ElementsPage extends BaseSeleniumPage {
    private static final Logger logger = LogManager.getLogger(ElementsPage.class);

    public ElementsPage(){
        PageFactory.initElements(driver, this);
        logger.info("Открыта страница: " + ConfigProvider.URL+"auto-complete");
    }

//    @FindBy(xpath = "//ul[@class='menu-list']")
//    private WebElement elements;

    @FindBy(xpath = "//div[contains(@class, 'element-group')][1]//li[contains(@id, 'item-')]")
    private List<WebElement> elementList;

    public List<WebElement> getElementsList() {
        return elementList;
    }
}