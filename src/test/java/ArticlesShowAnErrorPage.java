import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ArticlesShowAnErrorPage {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod

    public void openlink() {

        driver = new ChromeDriver();
        driver.get("https://academybugs.com/articles/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void ArticleOpenTesting() {

        WebElement Article = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='https://academybugs.com/wp-content/uploads/2015/10/pexels-photo-scaled-1-800x420.jpg']")));
        Article.click();

        // Wait until page loads (URL changes)
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe("https://academybugs.com/articles/")
        ));

        // Check if error message is displayed
        boolean isErrorDisplayed = driver.getPageSource()
                .contains("Oops! That page can’t be found.");

        // Assert that error page should NOT be displayed
        Assert.assertFalse(isErrorDisplayed,
                "BUG DETECTED: Error page displayed instead of article content!");


    }

}
