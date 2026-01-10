package opencart.Opencart;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.testng.Assert;

public class TC_RF_001 {

    @Test
    public static void TC_001() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("TC_RF_001 is Testing...");

        driver.get("https://tutorialsninja.com/demo/");


        // Click My Account
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@title='My Account']"))).click();

        // Click Register
        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Register"))).click();

        // Fill registration form
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("input-firstname"))).sendKeys("Vipul");

        driver.findElement(By.id("input-lastname")).sendKeys("Tarur");
        driver.findElement(By.id("input-email")).sendKeys(generateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
        driver.findElement(By.id("input-password")).sendKeys("Vipul@123");
        driver.findElement(By.id("input-confirm")).sendKeys("Vipul@123");

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        // ✅ Verify Success URL
        wait.until(ExpectedConditions.urlContains("route=account/success"));
        Assert.assertTrue(driver.getCurrentUrl().contains("route=account/success"),"Registration failed - URL mismatch");
        System.out.println("Url Verify Success");
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        
        String expectedResult="Your Account Has Been Created!";
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(),expectedResult);
        
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        
        System.out.println("TC_001 is Completed");
         driver.quit();
    }

    public static String generateEmail() {
        return "vipul" + System.currentTimeMillis() + "@gmail.com";
    }
}
