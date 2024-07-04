package Lesson_6.demoQa;


import Lesson_6.core.BaseSeleniumTest;
import Lesson_6.readProperrties.ConfigProvider;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;
import java.util.Arrays;


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
//        System.out.println(names);
        String[] actualList = names.split("\n+");
        System.out.println("Expected "+ Arrays.stream(expectedElements).toList());
        System.out.println("Actual "+ Arrays.stream(actualList).toList());
        Assertions.assertEquals(Arrays.stream(expectedElements).toList(), Arrays.stream(actualList).toList());
//        Assert(expectedElements.equals(actualList));
//        Assertions.assertEquals(expectedElements, actualList);
//        Assert.assertEquals(expectedElements, actualList);
//        logger.info("Assert returns");
    }
//
//    /**
//     * Assert that the first element from the collection consist of the expected entities list
//     */
    @Test
    public void verifyElementPageEntities() {
        String[] expectedList = {"Text Box", "Check Box", "Radio Button", "Web Tables", "Buttons", "Links", "Broken Links - Images", "Upload and Download", "Dynamic Properties"};
        MainPage mainPage2 = new MainPage();
        mainPage2.clicOnElements();

        ElementsPage sideBarElements = new ElementsPage();
        String[] actualList = sideBarElements.getElementsList().first().getText().split("\n+");
        String[] actualList = sideBarElements.getElementsList().
        Assertions.assertEquals(expectedList, actualList);
        Assert.assertEquals(expectedList, actualList);

        String expectedName = "Buttons";
        String names = sideBarElements.getElements().getText();
        boolean contains = names.contains(expectedName);
        Assert.assertTrue("Expected: element contains " + expectedName + " element name, Actual: <" + contains + ">", contains);
    }

//
//    /**
//     * Assert that the text is present on the page. Couldn't locate the element yet
//     */
//    // проверка на наличие текста на странице
////     @Test
////        public void returnText(){
////         pageObjects.MainPage mainPage3 = new pageObjects.MainPage(BASE_URL);
////         mainPage3.clicOnElements();
////            pageObjects.ElementsPage soughtElement = new pageObjects.ElementsPage();
//////        JavascriptExecutor js = (JavascriptExecutor) driver;
//////        String script = "return arguments[0].childNodes[arguments[0].childNodes.length - 1].nodeValue.trim();";
//////            String text = (String) js.executeScript(script, soughtElement.getMessage());
////            String text = soughtElement.getMessage().getText();
////            System.out.println(text);
//////            String actualText = soughtElement.getMessage().getText();
////        }
////  PROGRESS BA
//
//// 3. Using selenium webdriver to develop a test that handles the Progress Bar
//element (waiting for it to complete)
    /**
     * Assert that progress bar is complete
     */

//    @Test
//    public void getStartButtonStatus() throws InterruptedException {
//        ProgressBarPage progressBar = new ProgressBarPage();
//        progressBar.clickStartButton();
//        while (progressBar.getStartButton().getText().equals("Stop")) {
//            System.out.println("Do not press " + progressBar.getStartButton().getText());
//        }
//
//        if(progressBar.getStartButton().getText().equals("Reset")) {
//            System.out.println("The status of the button turned to = "+ progressBar.getStartButton().getText() + ", progress bar load is 100%");
//        }
//    }
//
// 4. Using selenium webdriver to develop a test that selects values from the list //[Red, Green, Purple, Indigo] on the page https://demoqa.com/autocomplete
//     "Type multiple color names". Important, 2 different values should //be selected at each run (use the Random function).

    /**
     * Select color randomly
     */
//    @Test
//    public void pickColorFromList() throws InterruptedException {
//        ColorCompletionPage colorCompletionPage = new ColorCompletionPage();
////        open(BASE_URL + "auto-complete");
//
//        String[] colors = {"Red", "Green", "Purple", "Indigo"};
//
//        colorCompletionPage.randomizer(colors);
//        System.out.println("Two random color sets have been selected");
//
//        driver.wait(20);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        Selenide.sleep(10000L);
//    }
//    // Picking each color separately
////        $(By.xpath("//input[@id='autoCompleteMultipleInput']")).setValue("Red").pressEnter();
////        $(By.xpath("//input[@id='autoCompleteMultipleInput']")).setValue("Green").pressEnter();
////        $(By.xpath("//input[@id='autoCompleteMultipleInput']")).setValue("Purple").pressEnter();
////        $(By.xpath("//input[@id='autoCompleteMultipleInput']")).setValue("Indigo").pressEnter();
//
//}
}