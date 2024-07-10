package Lesson_6.demoQa.Tests;

import Lesson_6.core.BaseSeleniumTest;
import Lesson_6.demoQa.Pages.ExamplePage;
import Lesson_6.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class TestRunner extends BaseSeleniumTest {
    public static void main(String[] args) {
        WebDriverManager webDriverManager = new WebDriverManager();
        WebDriver driver = webDriverManager.getDriver();

        try {
            webDriverManager.openUrl("https://demoqa.com/");
            ExamplePage examplePage = new ExamplePage(driver);
            examplePage.clickOnElements();
        } finally {
            webDriverManager.quit();
        }
    }
}
