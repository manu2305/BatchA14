package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.FileUtility.ReadFromProperties;

public class ReadProperties {
	public static WebDriver driver=null;
@Test
public void main() throws IOException {
	String browser = ReadFromProperties.readProperties("browser");
	System.out.println(browser);
	String url = ReadFromProperties.readProperties("url");
	System.out.println(url);
	String username = ReadFromProperties.readProperties("username");
	System.out.println(username);
	String password = ReadFromProperties.readProperties("password");
	System.out.println(password);
	
	
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
	
	
}
}
