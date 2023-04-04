package week6.assgn1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.sukgu.Shadow;


public class SpecificService {
	public ChromeDriver driver;
	public Shadow shadow; 
	public String excelsheet;

	@Parameters({"url", "username", "password"})
	@BeforeMethod
	public void preCondn(String url, String username, String password) {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	option.addArguments("--disable-notifications");
	driver = new ChromeDriver(option);
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	driver.findElement(By.id("user_name")).sendKeys(username);
	driver.findElement(By.id("user_password")).sendKeys(password);
	driver.findElement(By.id("sysverb_login")).click();
	shadow = new Shadow(driver);
	shadow.setImplicitWait(10);
	shadow.findElementByXPath("//div[@id='all']").click();
	}
	
	@AfterMethod
	public void postCondn() {
		driver.close();
	}
	
	@DataProvider (name="fetchdata")
	public String[][] inData() throws IOException{
		
		String[][] readData = InputData.readData(excelsheet);
		return readData;	
		
	}
	
}
	
