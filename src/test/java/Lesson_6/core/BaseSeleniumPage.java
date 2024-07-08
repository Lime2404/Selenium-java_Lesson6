package Lesson_6.core;

import Lesson_6.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;

abstract public class BaseSeleniumPage {
//    protected static WebDriver driver;
    WebDriverManager webDriverManager = new WebDriverManager();
    public WebDriver driver = webDriverManager.getDriver();

//    public static void setDriver(WebDriver webDriver){
//        driver = webDriver;
//    }
}
