package assignments.w4.d2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.nykaa.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Actions builder = new Actions(driver);
		
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();
		WebElement popular = driver.findElement(By.xpath("//a[text()='Popular']"));
		builder.moveToElement(popular).perform();
		driver.findElement(By.xpath("//a[@href='/brands/loreal-paris/c/595?eq=desktop']")).click();
		
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandlesList1.get(1));
		String pageTitle1 = driver.getTitle();
		if(pageTitle1.contains("L'Oreal Paris")) {
			System.out.println("L'Oreal Paris page has been loaded successfully.");
		}
		
		driver.findElement(By.xpath("//span[text()='Sort By : ']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		String filterApplied = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']")).getText();
		if(filterApplied.contains("Shampoo")) {
			System.out.println("Filter is applied with the criteria 'Shampoo'.");
		}
		
		driver.findElement(By.xpath("(//span[contains(text(),'Oreal Paris Colour Protect Shampoo')])[1]")).click();
		Set<String> windowHandlesSet2 = driver.getWindowHandles();
		List<String> windowHandlesList2 = new ArrayList<String>(windowHandlesSet2);
		driver.switchTo().window(windowHandlesList2.get(2));
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//span[text()='175ml']")).click();
		String price = driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])[1]")).getText();
		System.out.println("Price of L'Oreal Paris Colour Protect Shampoo 175ml: Rs." + price.replaceAll("[^0-9]", ""));
		
		driver.findElement(By.xpath("(//button[text()='ADD TO BAG'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='AddToBagbox']")).click();
		Thread.sleep(1000);
		String grandTotal = driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
		System.out.println("Grand total is: Rs." + grandTotal.replaceAll("[^0-9]", ""));

		/*String ifError = driver.findElement(By.xpath("//div[text()='Server Error']")).getText();
		if(ifError.contains("Server Error")) {
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		}*/
		
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		String grandTotal1 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		System.out.println("Grand total at checkout page:" + grandTotal1);
		
		String replaceAll = grandTotal.replaceAll("[^0-9]", "");
		int total = Integer.parseInt(replaceAll);
		
		String replaceAll1 = grandTotal1.replaceAll("[^0-9]", "");
		int total1 = Integer.parseInt(replaceAll1);
		
		if(total == total1) {
			System.out.println("Grand total before and after checkout is the same.");
		}
		
		
		
		
		
		
	}

}
