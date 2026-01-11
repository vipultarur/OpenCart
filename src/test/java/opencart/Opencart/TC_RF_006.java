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

public class TC_RF_006 {

    @Test
    public static void TC_001() {
        System.out.println("TC_RF_001 is Testing...");
        System.out.println("Validate Registering an Account when 'Yes' option is selected for Newsletter field");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


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
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        // ✅ Verify Success URLn 
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        
        String expectedResult="Your Account Has Been Created!";
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(),expectedResult);
        
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        
        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());
        System.out.println("TC_005 is Completed");
        driver.quit();
    }

    public static String generateEmail() {
        return "vipul" + System.currentTimeMillis() + "@gmail.com";
    }
}
