package opencart.Opencart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {
	@Test
	public static void main(String args[])
	{
		System.out.print("TC_RF_003 is Testing...");
		System.out.println("Validate Registering an Account by providing all the fields");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Vipul");
		driver.findElement(By.id("input-lastname")).sendKeys("Tarur");
	    driver.findElement(By.id("input-email")).sendKeys(generateEmail());
	    driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
	    driver.findElement(By.id("input-password")).sendKeys("Vipul@123");
	    driver.findElement(By.id("input-confirm")).sendKeys("Vipul@123");
	    driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	    driver.findElement(By.name("agree")).click();
//	    driver.findElement(By.xpath("//input[@name='agree']")).click();
	    
	    driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    wait.until(ExpectedConditions.urlContains("route=account/success"));
        Assert.assertTrue(driver.getCurrentUrl().contains("route=account/success"),"Registration failed - URL mismatch");
        System.out.println("Url Verify Success");
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        
        String expectedResult="Your Account Has Been Created!";
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(),expectedResult);
        
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        
        System.out.println("TC_002 is Completed");
        driver.quit();
	}
	public static String generateEmail() {
        return "vipul" + System.currentTimeMillis() + "@gmail.com";
    }

}
