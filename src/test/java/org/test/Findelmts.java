package org.test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Findelmts extends BaseClass {
	public static void main(String[] args) throws Throwable {
		browser("chrome");
	launchTheUrl("https://www.flipkart.com/");
	WebElement cancel = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	cancel.click();
	WebElement search = driver.findElement(By.name("q"));
	search.sendKeys("iphone");
	keyBoard(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	List<WebElement> phnName = driver.findElements(By.xpath("//div[@class='_13oc-S']//div/div[1]/a/div[2]/div[1]/div[1]"));
	for(WebElement x:phnName) {
		
		System.out.println(x.getText());
	}
	System.out.println("pricedetails");
	List<WebElement> price = driver.findElements(By.xpath("//div[@class='_13oc-S']//div/div[1]/a/div[2]/div[2]/div[1]/div[1]/div[1]"));

	
	
	List<WebElement> li=new ArrayList<WebElement>();
//	li.add((WebElement) price);
	for(WebElement p:price) {
		String amnt = p.getText();
		System.out.println(amnt);
	}
    Thread.sleep(4000);
	quit();
	
	}
}
