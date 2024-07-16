package Lesson_6.demoQa.Pages;

import Lesson_6.core.BaseSeleniumPage;
import Lesson_6.readProperrties.ConfigProvider;
import Lesson_6.utils.CalendarComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class RegistrationPage extends BaseSeleniumPage {

    public RegistrationPage() {
        driver.get(ConfigProvider.URL + "automation-practice-form#google_vignette");
        PageFactory.initElements(driver, this);
    }

    CalendarComponent calendarComponent = new CalendarComponent();

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "userEmail")
    private WebElement userEmailInput;

    @FindBy(id = "genterWrapper")
    private WebElement genderWrapper;

    @FindBy(id = "userNumber")
    private WebElement mobilePhoneInput;

    @FindBy(id = "dateOfBirthInput")
    private WebElement calendar;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(id = "uploadPicture")
    private WebElement pictureUploadButton;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "state")
    private WebElement stateDropDown;

    @FindBy(id = "city")
    private WebElement cityDropDown;

    @FindBy(id = "stateCity-wrapper")
    private WebElement cityDropDownWrapper;

    @FindBy(id = "google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0")
    private WebElement hideAdsButton;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0")
    private WebElement googleAdd;

    @FindBy(id = "adplus-anchor")
    private WebElement adplusAnchor;

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String mail) {
        userEmailInput.sendKeys(mail);
        return this;
    }

    public RegistrationPage chooseGenderInWrapper(String gender) {
        WebElement genderElement = genderWrapper.findElement(By.xpath(".//*[text()='" + gender + "']"));
        genderElement.click();
        return this;
    }

    public RegistrationPage setMobilePhone(String mobilePhone) {
        mobilePhoneInput.sendKeys(mobilePhone);
        return this;
    }

    public RegistrationPage setBirthDate(String year, String month, String day) {
        calendar.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public RegistrationPage setSubjectBySendKeys(String subject) {
        subjectsInput.sendKeys(subject);
        subjectsInput.sendKeys(Keys.ENTER);
        return this;
    }

    //
    public RegistrationPage setHobby(String hobby) {
        WebElement hobbyElement = driver.findElement(By.xpath("//*[text()='" + hobby + "']"));
        hobbyElement.click();
        return this;
    }


    public RegistrationPage uploadPicture(String fileName) throws URISyntaxException {

        String filePath = Paths.get(getClass().getClassLoader().getResource(fileName).toURI()).toString();
        pictureUploadButton.sendKeys(filePath);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.sendKeys(currentAddress);
        return this;
    }

    //
    public RegistrationPage selectStateFromDropDownList(String state) {
        // Scroll to the state dropdown
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateDropDown);
        stateDropDown.click();

        // Locate and click on the state option
        WebElement stateElement = driver.findElement(By.xpath("//*[text()='" + state + "']"));
        stateElement.click();
        return this;
    }

    public RegistrationPage selectCityFromDropDownList(String city) {
        cityDropDown.click();
        WebElement cityElement = cityDropDownWrapper.findElement(By.xpath(".//*[text()='" + city + "']"));
        cityElement.click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
