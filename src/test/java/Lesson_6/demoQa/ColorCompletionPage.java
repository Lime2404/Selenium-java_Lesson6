package Lesson_6.demoQa;


import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class ColorCompletionPage extends BaseSeleniumPage {

    //    private final static String BASE_URL = "https://demoqa.com/";
//    public ColorCompletionPage(String url){
//        Selenide.open(url);
    public ColorCompletionPage() {
        driver.get(ConfigProvider.URL + "progress-bar");
//        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='autoCompleteMultipleInput']")
    private WebElement inputElement;

    public void randomizer(String[] colors) {

        Random random = new Random();
        int firstIndex = random.nextInt(colors.length);
        int secondIndex;
        do {
            secondIndex = random.nextInt(colors.length);
        } while (secondIndex == firstIndex);

        String firstColor = colors[firstIndex];
        String secondColor = colors[secondIndex];
                                                                                                        //  VOVA: как задать данные цветов ?
//        inputElement

//        SelenideElement inputElement = $(By.xpath("//input[@id='autoCompleteMultipleInput']"));
//        inputElement.setValue(firstColor).pressEnter();
//        inputElement.setValue(secondColor).pressEnter();
    }
}
