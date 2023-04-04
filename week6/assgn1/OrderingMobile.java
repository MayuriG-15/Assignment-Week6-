package week6.assgn1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OrderingMobile extends SpecificService{
	@Test
	public void mobileorder() {
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service catalog");
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		WebElement frameele = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameele);
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
		WebElement dropcolor = driver.findElement(By.xpath("//select[@id='IO:60b15e33d7033100a9ad1e173e24d4a3']"));
		Select dropopt = new Select(dropcolor);
		dropopt.selectByIndex(3);
		WebElement dropsize = driver.findElement(By.xpath("//select[@id='IO:e0b15e33d7033100a9ad1e173e24d4a1']"));
		Select dropopt2 = new Select(dropsize);
		dropopt2.selectByIndex(2);
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		WebElement verifyorder = driver.findElement(By.xpath("//span[contains(text(),'Thank you')]"));
		if(verifyorder.getText().contains("Thank you")){
			System.out.println(verifyorder.getText());
			System.out.println("Your Order is placed");
		}else {
			System.out.println("Order is not placed");
		}
		String reqnum = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("Request Number : "+reqnum);
	
	}

}
