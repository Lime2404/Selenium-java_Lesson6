package Lesson_6.demoQa.Pages;

import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class ColorCompletionPage extends BaseSeleniumPage {
    private static final Logger logger = LogManager.getLogger(ColorCompletionPage.class);
    private String firstColorPlaceholder = null;
    private String secondColorPlaceholder = null;

    public String getFirstColorPlaceholder() {
        return firstColorPlaceholder;
    }

    public String getSecondColorPlaceholder() {
        return secondColorPlaceholder;
    }

    public ColorCompletionPage() {
        driver.get(ConfigProvider.URL + "auto-complete");
        PageFactory.initElements(driver, this);
        logger.info("The page: " + ConfigProvider.URL + "auto-complete" + " has been opened");
    }

    @FindBy(xpath = "//input[@id='autoCompleteMultipleInput']")
    private WebElement inputElement;

    @FindBy(xpath = "//div[@class='css-1rhbuit-multiValue auto-complete__multi-value'][1]")
    private WebElement firstColorElement;

    @FindBy(xpath = "//div[@class='css-1rhbuit-multiValue auto-complete__multi-value'][2]")
    private WebElement secondColorElement;


    public void randomizer(String[] colors) {
        Random random = new Random();
        int firstIndex = random.nextInt(colors.length);
        int secondIndex;

        do {
            secondIndex = random.nextInt(colors.length);
        } while (secondIndex == firstIndex);

        String firstColor = colors[firstIndex];
        String secondColor = colors[secondIndex];
        inputValuesWithSpace(firstColor);
        inputValuesWithSpace(secondColor);
        firstColorPlaceholder = firstColor;
        secondColorPlaceholder = secondColor;
    }

    private void inputValuesWithSpace(String value) {
        inputElement.sendKeys(value);
        inputElement.sendKeys(Keys.ENTER);
        logger.info("The color has been selected");
    }

    public String firstColorSelected() {
        return firstColorElement.getText();
    }

    public String secondColorSelected() {
        return secondColorElement.getText();
    }
}
