package week6.assgn1;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewCaller extends SpecificService {
	
	@BeforeTest
	public void outData() {
		excelsheet = "CallerCreation";
	}
	
	@Test(dataProvider = "fetchdata")
	public void newcaller(String uname, String fname, String lname, String title, String mailid, String pnum) throws IOException {
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//span[text()='Callers']").click();
		WebElement frmesel1 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frmesel1);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//input[@id='sys_user.user_name']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys(title);
		//driver.findElement(By.xpath("//input[@id='sys_display.sys_user.department']")).sendKeys("IT",Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys(mailid);
		WebElement langopt = driver.findElement(By.xpath("//select[@id='sys_user.preferred_language']"));
		Select langsel = new Select(langopt);
		langsel.selectByVisibleText("English");
		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys(pnum);
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		driver.findElement(By.xpath("//input[@id='sys_user_table_header_search_control']")).sendKeys(uname,Keys.ENTER);
		String inputid = driver.findElement(By.xpath("//table[@id='sys_user_table']//tr[1]/td[3]")).getText();
		String inputname = driver.findElement(By.xpath("//table[@id='sys_user_table']//tr[1]/td[4]")).getText();
		String inputeid = driver.findElement(By.xpath("//table[@id='sys_user_table']//tr[1]/td[5]")).getText();
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		File srcfile = driver.getScreenshotAs(OutputType.FILE);
		File destfile = new File("snap/callercreation.png");
		FileUtils.copyFile(srcfile, destfile);
		
		if(inputid.equals(uname)) {
			System.out.println("New Caller Created");
			System.out.println(inputid);
			System.out.println(inputname);
			System.out.println(inputeid);
		}else {
			System.out.println("Not Created");
		}
				
	}
	
}
