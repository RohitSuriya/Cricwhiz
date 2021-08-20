package assignments.w2d2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement dropDown1 = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select dd1 = new Select(dropDown1);
		dd1.selectByIndex(1);

		WebElement dropDown2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select dd2 = new Select(dropDown2);
		dd2.selectByVisibleText("Selenium");

		WebElement dropDown3 = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select dd3 = new Select(dropDown3);
		dd3.selectByValue("1");

		WebElement dropDown4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select dd4 = new Select(dropDown4);
		dd4.selectByIndex(1);
		int size = dd4.getOptions().size();
		System.out.println("The number of options in the drop down list is: " + size);

		driver.findElement(By.xpath("(//div[@class='example'])[5]//select")).sendKeys("Selenium");
		
		WebElement listBox = driver.findElement(By.xpath("(//div[@class='example'])[6]//select"));
		Select dd6 = new Select(listBox);
		dd6.selectByValue("1");

	}

}
