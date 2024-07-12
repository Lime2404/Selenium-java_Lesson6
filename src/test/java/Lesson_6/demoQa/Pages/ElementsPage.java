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
        logger.info("The page: " + ConfigProvider.URL+"auto-complete" + " has been opened");
    }

    @FindBy(xpath = "//div[contains(@class, 'element-group')][1]//li[contains(@id, 'item-')]")
    private List<WebElement> elementsList;

    public List<WebElement> getElementsList() {
        return elementsList;
    }
}