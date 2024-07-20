package Lesson_6.demoQa.Tests;

import Lesson_6.core.BaseSeleniumTest;
import Lesson_6.demoQa.Pages.*;
import Lesson_6.utils.ScrollPage;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class DemoqaSeleniumTest extends BaseSeleniumTest {

    //    7. Output all actions to the console using the Log4j library
    private static final Logger logger = LogManager.getLogger(DemoqaSeleniumTest.class);

// 2. Using selenium webdriver to develop smoke autotests for the main page

    /**
     * 1. Assert that all element can be found on the main page
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
        logger.info("Assert returns 200");
    }

    /**
     * 2. Assert that the first element from the collection consists of the expected entities list
     */
    @Test
    public void verifyElementPageEntities() {
        String[] expectedList = {"Text Box", "Check Box", "Radio Button", "Web Tables", "Buttons", "Links", "Broken Links - Images", "Upload and Download", "Dynamic Properties"};
        MainPage mainPage = new MainPage();
        ScrollPage.scrollPageDown(driver);
        mainPage.clickOnElements();

        ElementsPage sideBarElements = new ElementsPage();
        List<String> actualList = sideBarElements.getElementsList().stream().map(WebElement::getText).toList();
//        System.out.println("Expected list " + Arrays.stream(expectedList).toList());
//        System.out.println("Actual list " + Arrays.stream(actualList.toArray()).toList());
        Assertions.assertArrayEquals(expectedList, actualList.toArray());
        logger.info("Assert returns 200");
    }

//    3. Using selenium webdriver to develop a test that handles the Progress Bar
//    element (waiting for it to complete)
    /**
     * Handle the Progress Bar element (waiting for it to complete)
     */
    @Test
    public void getStartButtonStatus() {
        ProgressBarPage progressBar = new ProgressBarPage();
        ScrollPage.scrollPageDown(driver);
        progressBar.clickStartButton();
        while (progressBar.getStartButton().getText().equals("Stop")) {
        }

        if (progressBar.getStartButton().getText().equals("Reset")) {
            System.out.println("The status of the button turned to = " + progressBar.getStartButton().getText() + ", progress bar load is 100%");
        }
        Assertions.assertTrue(progressBar.getStartButton().getText().equals("Reset"));
        Assertions.assertTrue(progressBar.checkAreaValue().equals("100"));
        logger.info("The status of the button turned to = " + progressBar.getStartButton().getText() + ", progress bar load is 100%");
    }

// 4. Using selenium webdriver to develop a test that selects values from the list //[Red, Green, Purple, Indigo] on the page https://demoqa.com/autocomplete
//     "Type multiple color names". Important, 2 different values should //be selected at each run (use the Random function).
    /**
     * Select color randomly
     */
    @Test
    public void pickColorFromList() {
        ColorCompletionPage colorCompletionPage = new ColorCompletionPage();
        String[] colors = {"Red", "Green", "Purple", "Indigo"};
        ScrollPage.scrollPageDown(driver);
        colorCompletionPage.randomizer(colors);
        Assertions.assertEquals(colorCompletionPage.getFirstColorPlaceholder(),colorCompletionPage.firstColorSelected());
        Assertions.assertEquals(colorCompletionPage.getSecondColorPlaceholder(), colorCompletionPage.secondColorSelected());
        logger.info("Two random color sets have been selected");
    }

//   5. Using selenium webdriver to develop an autotest that fills out a form on the page

    /**
     * Fill in registration for
     */
    @Test
    // Я тут натыкал методов   ScrollPage.scrollPageDown(driver) так как значения не сетятся иначе

    void fillFormTest() throws URISyntaxException {
        RegistrationPage registrationPage = new RegistrationPage();

        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userEmailInput = "Ivan.Ivanov@mail.ru";
        String genderRadioPick = "Male";
        String mobilePhone = "7123123456";
        String subject = "Physics";
        String hobbiesSport = "Sports";
        String birthdayYear = "1987";
        String birthdayMonth = "April";
        String birthdayDate = "24";
        String state = "NCR";
        String city = "Delhi";
        String fileName = "img/Solveva.png";
        String currentAddressInput = "currentAddress";

        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(userEmailInput);
        registrationPage.setMobilePhone(mobilePhone);
        ScrollPage.scrollPageDown(driver);
        registrationPage.chooseGenderInWrapper(genderRadioPick);
        registrationPage.setSubjectBySendKeys(subject);
        ScrollPage.scrollPageDown(driver);
        registrationPage.setHobby(hobbiesSport);
        registrationPage.setCurrentAddress(currentAddressInput);
        registrationPage.selectStateFromDropDownList(state);
        registrationPage.selectCityFromDropDownList(city);
        registrationPage.uploadPicture(fileName);
        registrationPage.setBirthDate(birthdayYear, birthdayMonth, birthdayDate);
        ScrollPage.scrollPageDown(driver);  // можно обработку на JS прикрутить, но скролл тоже работает
        registrationPage.clickSubmitButton();
        Assertions.assertTrue(registrationPage.checkTableVisible());
        logger.info("The form is fully filled");
    }

// Cерег привет. Слушай, не могу победить вот этот warning : org.openqa.selenium.remote.http.WebSocket$Listener onError
//WARNING: Connection reset Но в дебаге всё нормально сетится
// посмотрел, что даже на stack overflow с такой же проблемой люди сталкиваются https://stackoverflow.com/questions/76782505/how-i-can-fix-this-warning-org-openqa-selenium-remote-http-websocketlistener-on

    @Test
//may be since I am in Kazakhstan, server sometimes is reseting connection, so I have this test to make sure server is responsive
    void mainTest() {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://demoqa.com/automation-practice-form#google_vignette");

        try {
            HttpResponse response = client.execute(request);
            System.out.println("Response Code: " + response.getCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}