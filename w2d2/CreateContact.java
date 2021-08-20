package assignments.w2d2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		// Verify if the landing page is correct - My Home | opentaps CRM
		String landPageExp = "My Home | opentaps CRM";
		String landPageAct = driver.getTitle();

		if (landPageExp.equals(landPageAct)) {
			System.out.println("The page loaded is the home page");
		} else {
			System.out.println("Page loaded is not expected");
		}
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("First");
		driver.findElement(By.id("lastNameField")).sendKeys("Last");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("First");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Last");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Technical");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Creating a contact");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("a@test.com");

		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd1 = new Select(state);
		dd1.selectByVisibleText("New York");

		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		WebElement editButton = driver.findElement(By.linkText("Edit"));
		if(editButton.isDisplayed()) {
			editButton.click();
		}
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Adding an important note.");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		String pageTitle = driver.getTitle();
		System.out.println("The title of the page is: " + "'" + pageTitle + "'");

		
	}

}
