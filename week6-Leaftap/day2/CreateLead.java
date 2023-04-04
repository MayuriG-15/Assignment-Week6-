package week6.day2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends SpecificMethods {
	
	@BeforeTest
	public void setUp() {
		excelsheet = "CreateLead";
	}
	
	@Test(dataProvider = "fetchdata")
	public void runCreate(String cname, String fname, String lname, String pnumb) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pnumb);
		driver.findElement(By.name("submitButton")).click();
		}

	
}






