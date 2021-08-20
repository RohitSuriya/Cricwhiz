package assignments.w2d2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
//import io.cucumber.core.plugin.Format.Color;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButtonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();

		Point location = driver.findElement(By.xpath("//button[contains(text(),'Position')]")).getLocation();
		System.out.println("The position of the button is: " + location);

		String bgColor = driver.findElement(By.xpath("//button[contains(text(),'am I')]")).getCssValue("background-color");
		String color = Color.fromString(bgColor).asHex();
		System.out.println("The color of the button is: " + bgColor);
		System.out.println("The color of the button is: " + color);
		
		String newColor = driver.findElement(By.xpath("//button[contains(text(),'am I')]")).getAttribute("style");
		System.out.println(newColor);
		
		Dimension size = driver.findElement(By.xpath("//button[contains(text(),'my size')]")).getSize();
		System.out.println("The size of the button is: " + size);
	}

}
