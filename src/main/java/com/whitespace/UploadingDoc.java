package com.whitespace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadingDoc {

	private static final String CHROME_DRIVER_PATH=UploadingDoc.class.getClassLoader().getResource("chromedriver.exe").getPath();
	private static final String DOC_PATH=UploadingDoc.class.getClassLoader().getResource("AA1.docx").getPath();
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https:/www.filebin.net/");
		driver.manage().window().maximize(); 
		
		
		WebElement selectfile = driver.findElement(By.id("fileField"));
		selectfile.sendKeys(DOC_PATH);
		
		Thread.sleep(3000);
		
		WebElement uploaded = driver.findElement(By.xpath("(//p[@class='lead'])[1]"));
		
		boolean result = uploaded.isDisplayed();
		System.out.println(result);
		
		String visibletext = uploaded.getText();
		System.out.println(visibletext);
		
	    driver.quit();
	    

	}

}
