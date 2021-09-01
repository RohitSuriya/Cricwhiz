package assignments.w4.d2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_MouseHover {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Actions builder = new Actions(driver);

		WebElement hoverElement = driver.findElement(By.linkText("TestLeaf Courses"));
		builder.moveToElement(hoverElement).perform();

		String course1 = driver.findElement(By.xpath("//a[text()='Selenium']")).getText();
		String course2 = driver.findElement(By.xpath("//a[text()='RPA']")).getText();
		String course3 = driver.findElement(By.xpath("//a[text()='WebServices']")).getText();

		List<String> courseList = new ArrayList<String>();
		courseList.add(course1);
		courseList.add(course2);
		courseList.add(course3);

		System.out.println("Courses offered at Test Leaf:" + courseList);

		builder.click(driver.findElement(By.xpath("//a[text()='Selenium']"))).perform();

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert after clicking on Selenium: " + alertText);
		alert.accept();

	}

}
