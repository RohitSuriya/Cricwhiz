package assignments.w4.d2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Actions builder = new Actions(driver);

		WebElement menFashion = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[2]"));
		builder.moveToElement(menFashion).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String shoeCount = driver.findElement(By.xpath("(//span[@class='category-count'])[1]")).getText();
		shoeCount = shoeCount.replaceAll("[^0-9]", "");
		System.out.println("Total count of men's sports shoe:" + shoeCount);

		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();

		/*
		 * List<WebElement> pricesList =
		 * driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		 * List<String> pricesList1 = new ArrayList<String>(); for (WebElement price :
		 * pricesList) { pricesList1.add(price.getText().replaceAll("[^0-9]", "")); }
		 * System.out.println(pricesList1);
		 */

		driver.findElement(By.xpath("(//button[text()='View More '])[3]")).click();
		driver.findElement(By.xpath("//a[contains(text(),' HASTAGMANVI')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'APPLY')]")).click();
		WebElement shoe = driver.findElement(By.xpath("//p[text()='HASTAGMANVI HM02-001 Gray Training Shoes']"));
		builder.moveToElement(shoe).perform();
		WebElement quickView = driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[2]"));
		builder.moveToElement(quickView).click().perform();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		
		String shoePrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String shoeDiscount = driver.findElement(By.xpath("//span[@class='pdpDiscount ']")).getText();
		shoeDiscount = shoeDiscount.replaceAll("[^0-9]", "");
		System.out.println("The price of the shoe is Rs." + shoePrice + " and the discount percentage is " + shoeDiscount + "%");
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File tgt = new File("./snaps/Snapdeal-Shoe.png");
		FileUtils.copyFile(src, tgt);
		
		//driver.close();
	}

}
