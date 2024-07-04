// Please ignore it for now


//package pageObjects;
//
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class ProgressBarPageTest {
//    private final static String BASE_URL = "https://demoqa.com/";
//    WebDriver driver = new ChromeDriver();
//    ProgressBarPage progressBar = new ProgressBarPage(BASE_URL + "progress-bar");
//
//    @Test
//    public void getProgressBarValues(){
//
//// почему драйвер поднимается дважды
//        progressBar.clickStartButton();
//          while(Integer.parseInt(progressBar.getAreaValue().toString()) < 100 ){
//             driver.manage().timeouts();
////              System.out.println(progressBar.getAreaValue().toString());
//          }
//// по какой-то причине перестала видеть элемент Element not found {By.xpath: //div[@class="progress-bar bg-info"]}
//
////          if(progressBar.getAreaSuccessValue().toString().equals("100")){
//          System.out.println("всё");
//
//          System.out.println(progressBar.getAreaSuccessValue().toString());
//    }
//}
