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

public class SocialShareButtonsTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openLink() {
        driver = new ChromeDriver();
        driver.get("https://academybugs.com/articles/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @Test
    public void facebook_button_testing() throws InterruptedException {

        // Get current URL
        String originalUrl = driver.getCurrentUrl();

        // Click Facebook share button
        WebElement facebook = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-facebook'])[1]"))
        );
        facebook.click();

        // Wait until URL changes
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(originalUrl)));

        // Get new URL
        String newUrl = driver.getCurrentUrl();

        // Assertion
        Assert.assertNotEquals(newUrl, originalUrl,
                "URL did not change after clicking Facebook share button!");

        Assert.assertTrue(newUrl.contains("facebook"),
                "Redirected URL is not Facebook!");

        //  WebElement twitter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-twitter'])[1]")));
        //twitter.click();
        //Thread.sleep(3000);

    }

    @Test
    public void twitter_button_testing() {

        String originalUrl = driver.getCurrentUrl();

        WebElement twitter = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//i[@class='fa fa-twitter'])[1]")
                )
        );

        twitter.click();

        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe(originalUrl)
        ));

        String newUrl = driver.getCurrentUrl();

        Assert.assertNotEquals(newUrl, originalUrl,
                "URL did not change after clicking Twitter share button!");

        Assert.assertTrue(newUrl.contains("twitter"),
                "Redirected URL is not Twitter!");
    }


    @Test
    public void pinterest_button_testing() {

        String originalUrl = driver.getCurrentUrl();

        WebElement pinterest = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//a[@id='square-share-a3'])[2]")
                )
        );

        pinterest.click();

        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlToBe(originalUrl)
        ));

        String newUrl = driver.getCurrentUrl();

        Assert.assertNotEquals(newUrl, originalUrl,
                "URL did not change after clicking pinterest share button!");

        Assert.assertTrue(newUrl.contains("pinterest"),
                "Redirected URL is not pinterest!");
    }


}







