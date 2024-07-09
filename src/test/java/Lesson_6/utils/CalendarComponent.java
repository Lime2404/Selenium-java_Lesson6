package Lesson_6.utils;

import Lesson_6.core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalendarComponent extends BaseSeleniumPage {

    public void setDate(String year, String month, String day) {

        WebElement yearSelect = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
        Select selectYear = new Select(yearSelect);
        selectYear.selectByValue(year); // 'year' should be a string representing the value you want to select

// Select the month
        WebElement monthSelect = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
        Select selectMonth = new Select(monthSelect);
        selectMonth.selectByVisibleText(month); // 'month' should be a string representing the visible text of the month you want to select

// Select the day
        WebElement dayElement = driver.findElement(By.cssSelector(".react-datepicker__day.react-datepicker__day--0" + day));
        dayElement.click();
    }
}
