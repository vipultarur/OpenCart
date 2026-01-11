package opencart.Opencart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {
	public static void main(String args[]) throws InterruptedException
	{
		System.out.println("TC_RF_004 is Testing...");
		System.out.println("Validate proper notification messages are displayed for the mandatory fields, when you don't provide any fields in the 'Register Account' page and submit");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/");
        
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        String expectedFirstNameWarnig="First Name must be between 1 and 32 characters!";
        String expectedLastNameWarnig="Last Name must be between 1 and 32 characters!";
        String expectedEMailWarnig="E-Mail Address does not appear to be valid!";
        String expectedTelephoneWarnig="Telephone must be between 3 and 32 characters!";
        String expectedPasswordWaring="Password must be between 4 and 20 characters!";
        String expectedPrivacyPolicyWaring="Warning: You must agree to the Privacy Policy!";
        
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),expectedFirstNameWarnig);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),expectedLastNameWarnig);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),expectedEMailWarnig);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedTelephoneWarnig);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),expectedPasswordWaring);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),expectedPrivacyPolicyWaring);

        
        
        Thread.sleep(4000);
        System.out.println("Testing Completed...");
        driver.quit();
        

	}
}
