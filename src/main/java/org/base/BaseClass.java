package org.base;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
 public static WebDriver driver;
  public static void browser(String browser) {
	  if(browser.equals("chrome")) {
	  
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  }
	  else if(browser.equals("firefox")) {
	  WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
	  }
	  else {
	  WebDriverManager.iedriver().setup();
	  driver=new InternetExplorerDriver();
  }
    
  }
  public static void launchTheUrl(String url) {
 	 driver.get(url);
 	 driver.manage().window().maximize();
 	 
  }
  public static void fillTheTextBox(WebElement e,String value) {
	  e.sendKeys(value);
 	 
  }
  public static String getTitle() {
	  String title = driver.getTitle();
	  System.out.println(title);
	return title;
	  
  }
  public static String geturll() {
	  String currentUrl = driver.getCurrentUrl();
	  System.out.println(currentUrl);
	return currentUrl;
  }
  public static void clickbutton(WebElement a) {
	  a.click();
	  
  }
  public static void quit() {
	  driver.quit();
  }
  public static void screenShot(String spath) throws Exception {
	  TakesScreenshot t=(TakesScreenshot)driver;
		File temp = t.getScreenshotAs(OutputType.FILE);
		File perm=new File(spath);
		FileUtils.copyFile(temp, perm);
	  

}
  public static void dropDown(WebElement d,String valuee) {
	Select s=new Select(d);
	 s.selectByVisibleText(valuee);
	 System.out.println(d.getAttribute("value"));
	

}
  public static void alertaction(String action) {
	  if(action.equals("accept")) {
	  Alert a=driver.switchTo().alert();
	  a.accept();
	  }
	  else{
		  Alert a=driver.switchTo().alert();
		  a.dismiss();
	  }
	 

}
  public static void mouseActions(String action,WebElement value) {
	  Actions a=new Actions(driver);
	  if(action.equals("click")) {
	  a.moveToElement(value).click().build().perform();
	  }
	  else if(action.equals("double")) {
		a.moveToElement(value).doubleClick().build().perform();
	  }
	  else {
		a.moveToElement(value).contextClick().build().perform();
	  } 
  }
  public static void dragDrop(WebElement d, WebElement d1) {
	  Actions a=new Actions(driver);
//			a.dragAndDrop(d, d1).perform();
		//a.clickAndHold(drag).moveToElement(drop).release().build().perform();
		a.moveToElement(d).clickAndHold().release(d1).build().perform();
  }
  public static void keyBoard(int k) throws Exception {
	  Robot r=new Robot();
	  
	  r.keyPress(k);
	  r.keyRelease(k);
  }
//  public static void excelread(String fpath ,String sname,String action,int r,int c) throws Exception {
//		File f=new File(fpath);
//		FileInputStream fis=new FileInputStream(f);
//		Workbook wb=new XSSFWorkbook(fis);
//		Sheet sheet=wb.getSheet(sname);
//		if(action.equals("single")) {
//
//			Row row=sheet.getRow(r);
//			Cell cell=row.getCell(c);
//			System.out.println(cell);
//		}
//		else {
//		int rcount = sheet.getPhysicalNumberOfRows();
//		System.out.println(rcount);
//		
//		Row row=sheet.getRow(1);
//		int ccount = row.getPhysicalNumberOfCells();
//		Cell cell=row.getCell(0);
//		System.out.println(cell);
//		System.out.println();
//
//		for(int i=0; i<rcount;i++) {
//			Row row2 = sheet.getRow(i);
//			for(int j=0;j<ccount;j++) {
//				Cell cell2 = row2.getCell(j);
//				int type = cell2.getCellType();
//				
//				if(type==1) {
//					String value = cell.getStringCellValue();
////					System.out.println(value);	
//				}
//				else if(DateUtil.isCellDateFormatted(cell2)) {
//					Date date = cell2.getDateCellValue();
//					SimpleDateFormat s=new SimpleDateFormat("dd-mm-yyyy");
//					String value = s.format(date);
////					System.out.println(value);
//				}
//				else {
//					double d = cell2.getNumericCellValue();
//					long l=(long)d;
//					String value = String.valueOf(l);
////					System.out.println(value);
//				}
//			System.out.println(cell2);
////			System.out.println(type);
//			}
//			System.out.println();
//}
//		}
//  }		
//  public static void excelWrite(String fpath ,String sname, String value,int r, int c) throws Exception {
//	  File f=new File(fpath);
////	  boolean fc = f.createNewFile();
////	  System.out.println(fc);
//		FileOutputStream fos =new FileOutputStream(f);
////		FileInputStream fis=new FileInputStream(f);
//		Workbook wb=new XSSFWorkbook();
//		Sheet sheet = wb.createSheet(sname);
//		Row row = sheet.createRow(r);
//		Cell cell = row.createCell(c);
//		cell.setCellValue(value);
//		
////		FileOutputStream fos =new FileOutputStream(f);
//
//		wb.write(fos);
//  }
}
