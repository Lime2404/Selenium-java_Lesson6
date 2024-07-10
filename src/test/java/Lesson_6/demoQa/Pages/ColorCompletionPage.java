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
    public ColorCompletionPage() {
        driver.get(ConfigProvider.URL + "auto-complete");
        PageFactory.initElements(driver, this);
        logger.info("Открыта страница: " + ConfigProvider.URL+"auto-complete");
    }


    @FindBy(xpath = "//input[@id='autoCompleteMultipleInput']")
    private WebElement inputElement;

    public void randomizer(String[] colors) throws InterruptedException {

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
        //  VOVA: как задать данные цветов ?
//        inputElement

//        SelenideElement inputElement = $(By.xpath("//input[@id='autoCompleteMultipleInput']"));
//        inputElement.sendKeys(firstColor);
////        driver.wait(10);
//        inputElement.sendKeys(secondColor);
//        inputElement.setValue(firstColor).pressEnter();
//        inputElement.setValue(secondColor).pressEnter();

    }
    private void inputValuesWithSpace(String value){
        inputElement.sendKeys(value);
//        inputElement.sendKeys(" ");
        inputElement.sendKeys(Keys.ENTER);
        logger.info("Цвет выбраны");
    }
}