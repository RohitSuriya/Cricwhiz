package assignments.w4.d2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_Selectable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Actions builder = new Actions(driver);

		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
		
		builder.clickAndHold(item1).moveToElement(item7).release().perform();
		driver.close();

	}

}
