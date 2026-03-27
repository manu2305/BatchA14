package Assertions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertMethods {
@Test(enabled = true)
public void hardAssert() throws InterruptedException {
	String expected_url="https://www.myntra.com/";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.myntra.com/");
	assertEquals(driver.getCurrentUrl(),expected_url,"iam not in my targeted page");
	WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
	Thread.sleep(1000);
	Actions act=new Actions(driver);
	act.moveToElement(men).perform();
	WebElement jackets = driver.findElement(By.xpath("//a[text()='Jackets' and @data-reactid='41']"));
	assertTrue(jackets.isDisplayed(),"Jackets section is not displayed");
	driver.close();

}
@Test
public void softAssert() throws InterruptedException {
	String expected_url="https://www.myntra.com";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.myntra.com/");
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(driver.getCurrentUrl(),expected_url,"iam not in my targeted page");
	WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
	Thread.sleep(1000);
	Actions act=new Actions(driver);
	act.moveToElement(men).perform();
	WebElement jackets = driver.findElement(By.xpath("//a[text()='Jackets' and @data-reactid='41']"));
	soft.assertTrue(jackets.isDisplayed(),"Jackets section is not displayed");
	driver.close();
	soft.assertAll();
}
}
