package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.Pom.Login;

public class ExecuteLogin {
@Test
public void valid() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Login log=new Login(driver);
	log.username().sendKeys("Admin");
	log.password().sendKeys("admin123");
	log.loginButton().click();
	Thread.sleep(3000);
	driver.close();
}
}
