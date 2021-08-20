package assignments.w2d2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("shaikchintu989@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();

		WebElement firstName = driver.findElement(By.xpath("(//a[contains(text(),'Gangadhar')])[2]"));
		WebElement lastName = driver.findElement(By.xpath("(//a[contains(text(),'Mundru')])[2]"));

		String name = firstName.getText() + " " + lastName.getText();
		System.out.println("Name of the lead: " + name);

		firstName.click();
		driver.findElement(By.partialLinkText("Duplicate Lead")).click();
		String title = driver.getTitle();
		if (title.contains("Duplicate Lead")) {
			driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		}

		String fName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		String lName = driver.findElement(By.xpath("//span[@id='viewLead_lastName_sp']")).getText();
		String duplicateName = fName + " " + lName;
		System.out.println("Duplicate Name: " + duplicateName);
		if (name.equals(duplicateName)) {
			System.out.println("Duplicated name is " + duplicateName + "and it is same as the orginal name");
		}
		driver.close();

	}

}
