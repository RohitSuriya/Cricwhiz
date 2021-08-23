package assignments.w2d1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.name("username")).sendKeys("Open cart user");
		driver.findElement(By.name("firstname")).sendKeys("Open");
		driver.findElement(By.name("lastname")).sendKeys("Cart");
		driver.findElement(By.name("email")).sendKeys("test@testleaf.com");

		WebElement country = driver.findElement(By.id("input-country"));
		Select dropDown1 = new Select(country);
		dropDown1.selectByValue("99");

		driver.findElement(By.name("password")).sendKeys("password");
	}

}
