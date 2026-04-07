import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Booking_Page {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod

    public void openlink() {

        driver = new ChromeDriver();
        driver.get("https://academybugs.com/my-bookings/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test

    public void BookingPage(){

        WebElement datepick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='picker__holder'])[1]")));
        datepick.sendKeys("April 8,2026");

        WebElement time = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='rtb-time']")));
        time.sendKeys("6.00 AM");

        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='rtb-name']")));
        name.sendKeys("Varuni");







    }

}
