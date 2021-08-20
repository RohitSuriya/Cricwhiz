package assignments.w2d2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		WebElement phoneCC = driver.findElement(By.name("phoneCountryCode"));
		phoneCC.clear();
		phoneCC.sendKeys("2");
		driver.findElement(By.name("phoneAreaCode")).sendKeys("91");
		driver.findElement(By.name("phoneNumber")).sendKeys("9566252734");
		driver.findElement(By.xpath("(//button[contains(text(),'Find Leads')])")).click();

		WebElement leadID = driver.findElement(By.xpath("(//a[contains(text(),'10492')])[1]/.."));
		String text = leadID.getText();
		System.out.println("The lead ID is: " + text);

		driver.findElement(By.linkText("10492")).click();
		driver.findElement(By.linkText("Delete")).click();

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();

		String searchResult = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
		if (searchResult.equals("No records to display")) {
			System.out.println("The lead ID " + "'" + text + "'" + "is deleted successfully");
		}
		driver.close();
	}

}
