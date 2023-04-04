package week6.assgn1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KnowledgeDetails extends SpecificService{
	
	@BeforeTest
	public void outData() {
		excelsheet = "Knowledge";
	}
	
	@Test(dataProvider = "fetchdata")
	public void articleDetails(String base, String desp, String article) {
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge");
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//span[text()='Knowledge']").click();
		WebElement frame1 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']")).sendKeys(base,Keys.ENTER);
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_category']")).click();
		driver.findElement(By.xpath("//span[text()='IT']")).click();
		driver.findElement(By.xpath("//span[text()='Java']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys(desp);
		driver.findElement(By.xpath("//button[@id='mceu_0-open']")).click();
		driver.findElement(By.xpath("//span[text()='Times New Roman']")).click();
		driver.findElement(By.xpath("//button[@id='mceu_1-open']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'10')]")).click();
		driver.findElement(By.xpath("//button[@id='mceu_3-button']")).click();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='kb_knowledge.text_ifr']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(article);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
				
	}
	
	
}
