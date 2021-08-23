package assignments.w2d1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		if (driver.getTitle().equals("Facebook – log in or sign up")){
				driver.findElement(By.linkText("Create New Account")).click();
				
				driver.findElement(By.name("firstname")).sendKeys("firstname");
				driver.findElement(By.name("lastname")).sendKeys("surname");
				driver.findElement(By.name("reg_email__")).sendKeys("0123456789");
				driver.findElement(By.id("password_step_input")).sendKeys("newpass123");
				
				WebElement day = driver.findElement(By.id("day"));
				Select dropDown1 = new Select(day);
				dropDown1.selectByValue("10");
				
				WebElement month = driver.findElement(By.id("month"));
				Select dropDown2 = new Select(month);
				dropDown2.selectByValue("10");
				
				WebElement year = driver.findElement(By.id("year"));
				Select dropDown3 = new Select(year);
				dropDown3.selectByValue("1990");
				
				driver.findElement(By.xpath("//label[text()='Custom']")).click();
				
				WebElement pronoun = driver.findElement(By.name("preferred_pronoun"));
				Select dropDown4 = new Select(pronoun);
				dropDown4.selectByValue("2");
				
				driver.findElement(By.name("custom_gender")).sendKeys("Mr");
		}

	}

}
