import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Searchbuttonerror {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod

    public void openlink() {

        driver = new ChromeDriver();
        driver.get("https://academybugs.com/store/dnk-yellow-shoes/?single");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test

    public void searchButtonError(){

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='ec_search']")));
        search.sendKeys("Shoes");

        WebElement searchbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Search']")));
        searchbtn.click();
    }

}
