package assignments.w2d1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Sales");
		driver.findElement(By.name("UserLastName")).sendKeys("Force");
		driver.findElement(By.name("UserEmail")).sendKeys("salsforce@testleaf.com");
		driver.findElement(By.name("CompanyName")).sendKeys("Testleaf");
		driver.findElement(By.name("UserPhone")).sendKeys("1234567890");
		
		WebElement jobTitle = driver.findElement(By.name("UserTitle"));
		Select dropDown1 = new Select(jobTitle);
		dropDown1.selectByValue("Others_AP");
		
		WebElement employees = driver.findElement(By.name("CompanyEmployees"));
		Select dropDown2 = new Select(employees);
		dropDown2.selectByIndex(4);
		
		WebElement country = driver.findElement(By.name("CompanyCountry"));
		Select dropDown3 = new Select(country);
		dropDown3.selectByValue("IN");
		
		driver.findElement(By.className("checkbox-ui")).click();
		driver.close();
	}

}
