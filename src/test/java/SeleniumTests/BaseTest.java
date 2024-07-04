package SeleniumTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

// 1. Create a Maven project (Java) using the following libraries:
abstract public class BaseTest {
    @BeforeAll

//    protected WebDriver driver;

    public static void setUp() {
        SelenideConfig.setup();
        SelenideLogger.addListener("SeleniumTests.SelenideLogListener", new SelenideLogListener());

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
//        Configuration.driverManagerEnabled = true; // deprecated
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

        @Before
         public void init(){
            setUp();
            System.out.println("Запускаемся");
        }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
