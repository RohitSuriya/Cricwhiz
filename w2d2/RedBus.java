package assignments.w2d2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement fromTextBox = driver.findElement(By.xpath("//input[@data-message='Please enter a source city']"));
		fromTextBox.sendKeys("Chennai");
		fromTextBox.sendKeys(Keys.ENTER);

		WebElement toTextBox = driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']"));
		toTextBox.sendKeys("Bengaluru");
		toTextBox.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		driver.findElement(By.xpath("//td[text()='20']")).click();
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		//driver.findElement(By.xpath("(//div[@class='close'])/i")).click();

		String results = driver.findElement(By.xpath("(//span[@class='f-bold busFound']")).getText();
		System.out.println("Total number of buses retruned: " + results);

		driver.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[1]")).click();
		String sleeperBus = driver.findElement(By.xpath("//span[@class='f-bold busFound'])")).getText();
		System.out.println("Number of sleeper buses: " + sleeperBus);

		driver.findElement(By.xpath("(//label[@for='bt_NONAC'])[1]")).click();
		String nonACSleeper = driver.findElement(By.xpath("(//span[@class='f-bold busFound'])[1]")).getText();
		System.out.println("Number of sleeper buses: " + nonACSleeper);

		driver.close();

	}

}
