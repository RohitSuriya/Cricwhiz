package assignments.w4.d1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow_Frames {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev113545.service-now.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement frameElement = driver
				.findElement(By.xpath("//div[@class='navpage-main-left ng-isolate-scope']/iframe"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.xpath("//button[@name='not_important']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("(//div[text()='Incidents'])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();

		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> callerWindowHandlesSet = driver.getWindowHandles();
		List<String> callerWindowHandlesList = new ArrayList<String>(callerWindowHandlesSet);
		driver.switchTo().window(callerWindowHandlesList.get(1));
		driver.findElement(By.xpath("(//a[@role='button'])[7]")).click();
		driver.switchTo().window(callerWindowHandlesList.get(0));

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//a[@id='lookup.incident.short_description']")).click();
		Set<String> shortDescWindowHandlesSet = driver.getWindowHandles();
		List<String> shortDescWindowHandlesList = new ArrayList<String>(shortDescWindowHandlesSet);
		driver.switchTo().window(shortDescWindowHandlesList.get(1));
		driver.findElement(By.xpath("//a[text()='Issue with a web page']")).click();
		driver.switchTo().window(shortDescWindowHandlesList.get(0));

		driver.switchTo().frame("gsft_main");
		String incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident Number: " + incidentNumber);

		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();

		WebElement findElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select dropDown = new Select(findElement);
		dropDown.selectByVisibleText("Number");
		driver.findElement(By.xpath("((//input[@class='form-control'])[1])")).sendKeys(incidentNumber, Keys.ENTER);
		// driver.findElement(By.xpath("(//button[@aria-controls='incident_table_header_search_control'])[1]")).click();

		WebElement searchResultElement = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]"));
		String searchResult = searchResultElement.getText();

		if (searchResult.equals(incidentNumber)) {
			System.out.println("Incident has been successfully created.");
		}

		searchResultElement.click();

		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./snaps/IncidentSnap.png");
		FileUtils.copyFile(src1, dest1);

	}

}
