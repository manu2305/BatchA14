package Annotation;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateDependency {
	@Test(dependsOnMethods = "mi")
	public void rcb() {
		Reporter.log("iam Rcb",true);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.royalchallengers.com/");
		driver.quit();
	}
		@Test()
		public void mi() {
			Reporter.log("Iam MI",true);
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://www.mumbaiindians.com/");
			driver.quit();	
			fail("Because of umpire");
		}

		@Test()
		public void csk() {
			Reporter.log("iam Csk",true);
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://www.chennaisuperkings.com/");
			driver.quit();	
		}
		
}
