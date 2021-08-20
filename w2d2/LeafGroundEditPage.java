package assignments.w2d2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEditPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@testleaf.com");

		WebElement appendText = driver.findElement(By.xpath("//input[@value='Append ']"));
		appendText.sendKeys("text");
		appendText.sendKeys(Keys.TAB);

		String defaultText = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getText();
		System.out.println(defaultText);

		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		boolean textBoxEnabled = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();

		if (textBoxEnabled) {
			System.out.println("The text box is enabled");
		} else {
			System.out.println("The text box is disabled");
		}

	}

}
