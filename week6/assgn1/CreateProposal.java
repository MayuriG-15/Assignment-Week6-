package week6.assgn1;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateProposal extends SpecificService {
	
	@BeforeTest
	public void outData() {
		excelsheet = "Proposal";
	}
	
	@Test(dataProvider = "fetchdata")
	public void createnew(String temp) {
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Proposal");
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//span[text()='My']").click();
		WebElement selframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(selframe);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys(temp);
		driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
			
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		driver.findElement(By.xpath("(//input[@class='list_header_search  form-control form-control-search'])[2]")).sendKeys(temp, Keys.ENTER);
		String confirmproposal = driver.findElement(By.xpath("//table[@id='std_change_proposal_table']//tr[1]/td[4]")).getText();
		System.out.println(confirmproposal);
		if(confirmproposal.equals(temp)) {
			System.out.println("New Proposal successfully created");
		}else {
			System.out.println("Not Created");
		}
		
	}

}
