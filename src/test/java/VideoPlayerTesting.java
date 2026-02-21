import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VideoPlayerTesting {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod

    public void openlink(){

        driver = new ChromeDriver();
        driver.get("https://academybugs.com/latest-news/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void firstVideoWorkTesting(){

        WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='plyr__controls'])[1]")));
        playBtn.click();

        // Locate video element
        WebElement video = driver.findElement(By.xpath("(//video[@preload='metadata'])[1]"));

// Check if video is playing using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Boolean isPlaying = (Boolean) js.executeScript(
                "return arguments[0].paused == false;", video);

        Assert.assertTrue(isPlaying, "Video is not playing. Black screen detected!");
    }


    @Test
    public void secondVideoTest(){

        WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='Play'])[4]")));
        playBtn.click();

    }
}
