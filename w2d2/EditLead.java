package assignments.w2d2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("hello");
		driver.findElement(By.xpath("(//button[text()='Find Leads'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='hello'])[1]")).click();
		
		String pageTitle = driver.getTitle();
		if (pageTitle.contains("View Lead | opentaps CRM")) {
			driver.findElement(By.xpath("(//a[text()='Edit'])[1]")).click();
		}
		
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys("New company name");
		
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		
		String newCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (newCompanyName.contains("New company name")) {
			System.out.println("The company name has been updated successfully");
		}
		
		
	}

}
