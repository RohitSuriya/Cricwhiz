package assignments.w3d2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class List_Selenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@placeholder='Search AJIO']")).sendKeys("bags");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Fashion Bags')]")).click();
		Thread.sleep(2000);
		WebElement results = driver.findElement(By.xpath("((//div[@class='filter-container'])//div[1])//div[1]"));
		String text = results.getText();
		System.out.println("Total result found: " + text);
		
		List<WebElement> bagBrand = driver.findElements(By.className("name"));
		int bagbrandSize = bagBrand.size();
		System.out.println("Total brands: " + bagbrandSize);
		System.out.println('\n' + "Names of the Bags displayed:" + '\n');
		for (WebElement webElement : bagBrand) {
			String brandName = webElement.getText();
			System.out.println(brandName);
		}
	}

}
