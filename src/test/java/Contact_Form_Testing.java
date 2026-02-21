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

public class Contact_Form_Testing {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openLink(){

        driver = new ChromeDriver();
        driver.get("https://academybugs.com/contact-us-form/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @Test
    public void contact_form(){

        WebElement fname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='first_name'])[1]")));
        fname.sendKeys("Neon");

        WebElement Lname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='Last Name'])[1]")));
        Lname.sendKeys("Vikky");

        WebElement Email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='Email'])[1]")));
        Email.sendKeys("neonv@gmail.com");

        WebElement Sub = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='Subject'])[1]")));
        Sub.sendKeys("For more details");

        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='input-message'])[1]")));
        message.sendKeys("I want to more details about software engineer job role");

        WebElement send = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit-contact-form']")));
        send.click();

        // Wait until error message is visible
        WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//p[normalize-space()='Oops! Something went wrong.'])[1]")
                )
        );

// Verify error message is displayed
        Assert.assertTrue(errorMsg.isDisplayed(),
                "Error message is not displayed after clicking Send button!");











    }
}
