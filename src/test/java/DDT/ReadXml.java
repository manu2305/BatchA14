package DDT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ReadXml {
	WebDriver driver=null;
@Parameters("url")
@Test
public void main1(String url) {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	System.out.println("Iam Main1");
	driver.close();
}

@Parameters({"browser","url","username","password"})
@Test
public void main2(String browser,String url,String username,String password) {
	if(browser.equalsIgnoreCase("chrome")) {
		 driver=new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(url);
	driver.findElement(By.className("ico-login")).click();
	driver.findElement(By.id("Email")).sendKeys(username);
	driver.findElement(By.id("Password")).sendKeys(password);
	driver.findElement(By.cssSelector(".button-1.login-button")).click();
	System.out.println("Iam Main2");
	driver.close();
}
}
