package Lesson_6.demoQa;


import Lesson_6.core.BaseSeleniumTest;
import Lesson_6.readProperrties.ConfigProvider;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class DemoqaSeleniumTest extends BaseSeleniumTest {
//    private final static String BASE_URL = "https://demoqa.com/";
//    WebDriver driver = new ChromeDriver();
//    private static final Logger logger = LogManager.getLogger(DemoqaSeleniumTest.class);

    @Test
    public void checkChrome() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }


// 2. Using selenium webdriver to develop smoke autotests for the main page

    /**
     * Assert that all element can be found on the main page
     */
    @Test
    public void assertMainPageElements() {
        String[] expectedElements = {"Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store Application"};
        MainPage mainPage = new MainPage();
        String names = mainPage.returnCard();
        String[] actualList = names.split("\n+");
//        System.out.println("Expected "+ Arrays.stream(expectedElements).toList());
//        System.out.println("Actual "+ Arrays.stream(actualList).toList());
        Assertions.assertArrayEquals(expectedElements, actualList);
//        logger.info("Assert returns");
    }
    //may be since I am in Kazakhstan, server sometimes is reseting connection
//
//    /**
//     * Assert that the first element from the collection consist of the expected entities list
//     */
    @Test
    public void verifyElementPageEntities() throws InterruptedException {
        String[] expectedList = {"Text Box", "Check Box", "Radio Button", "Web Tables", "Buttons", "Links", "Broken Links - Images", "Upload and Download", "Dynamic Properties"};
        MainPage mainPage2 = new MainPage();

        mainPage2.clickOnElements();
//        wait(10000L);

        ElementsPage sideBarElements = new ElementsPage();
        List<String> actualList = sideBarElements.getElementsList().stream().map(WebElement::getText).collect(Collectors.toList());
        System.out.println(expectedList);
        System.out.println(actualList.toArray());
        //        List<String> actualList = sideBarElements.getElementsList().stream().map(WebElement::getText).toList();
        Assertions.assertArrayEquals(expectedList, actualList.toArray());
    }

    @Test
    public void getStartButtonStatus() {
        ProgressBarPage progressBar = new ProgressBarPage();
        progressBar.clickStartButton();
        while (progressBar.getStartButton().getText().equals("Stop")) {
            System.out.println("Do not press " + progressBar.getStartButton().getText());
        }

        if(progressBar.getStartButton().getText().equals("Reset")) {
            System.out.println("The status of the button turned to = "+ progressBar.getStartButton().getText() + ", progress bar load is 100%");
        }
    }

// 4. Using selenium webdriver to develop a test that selects values from the list //[Red, Green, Purple, Indigo] on the page https://demoqa.com/autocomplete
//     "Type multiple color names". Important, 2 different values should //be selected at each run (use the Random function).

    /**
     * Select color randomly
     */
    @Test
    public void pickColorFromList() throws InterruptedException {
        ColorCompletionPage colorCompletionPage = new ColorCompletionPage();

        String[] colors = {"Red", "Green", "Purple", "Indigo"};

        colorCompletionPage.randomizer(colors);
        System.out.println("Two random color sets have been selected");

        wait(10000L);
//        driver.wait(20);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.wait(10);
//        int a = 0;
//        Selenide.sleep(10000L);

    }
}