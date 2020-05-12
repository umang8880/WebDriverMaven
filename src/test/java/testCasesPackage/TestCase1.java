package testCasesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase1 extends Base{

	@Test(dataProviderClass = ExcelReading.class,  dataProvider = "dp1")
	public void gmailLogin(String username, String password) {
		//Checking for status Pass
		
		driver.get("https://gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys(username);
	}
	
	@Test(priority=1, dataProviderClass = ExcelReading.class,  dataProvider = "dp1")
	public void doFBLogin(String username, String password) {
		//Checking for status Fail
		driver.get("https://facebook.com");
		WebElement username1 = driver.findElement(By.id("email"));
		username1.sendKeys(username);
		
		WebElement password1 = driver.findElement(By.id("passsssss"));
		password1.sendKeys(password);
		
		WebElement login = driver.findElement(By.id("u_0_b"));
		login.click();
	}
	
//	@Test(priority = 2, dependsOnMethods = "doFBLogin")
//	public void navigateFBProfile() {
//		
//		driver.findElement(By.xpath("//span[@class='_1vp5']")).click();
//	}
	
	@Test
	public void isSkip() {
		throw new SkipException("Skipping this method");
	}
}
