package assignments.w4.d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		Set<String> fromWindowHandlesSet = driver.getWindowHandles();
		List<String> fromWindowHandlesList = new ArrayList<String>(fromWindowHandlesSet);
		driver.switchTo().window(fromWindowHandlesList.get(1));
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

		driver.switchTo().window(fromWindowHandlesList.get(0));

		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		Set<String> toWindowHandlesSet = driver.getWindowHandles();
		List<String> toWindowHandlesList = new ArrayList<String>(toWindowHandlesSet);
		driver.switchTo().window(toWindowHandlesList.get(1));
		// System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();

		driver.switchTo().window(fromWindowHandlesList.get(0));
		
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alertMergeContact = driver.switchTo().alert();
		alertMergeContact.accept();
		System.out.println(("Page title: " + driver.getTitle()));

	}

}
