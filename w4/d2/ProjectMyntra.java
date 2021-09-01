package assignments.w4.d2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectMyntra {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);

		WebElement men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		builder.moveToElement(men).perform();
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();

		String totalCount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String replaceAll = totalCount.replaceAll("[^0-9]", "");
		int totalResults = Integer.parseInt(replaceAll);
		System.out.println("Total count of jackets: " + totalResults);

		String jacketsString = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String replaceJackets = jacketsString.replaceAll("[^0-9]", "");
		int jacketCount = Integer.parseInt(replaceJackets);
		System.out.println("Count of normal jackets:" + jacketCount);

		String rainJacketsString = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String replaceRainJackets = rainJacketsString.replaceAll("[^0-9]", "");
		int rainJacketCount = Integer.parseInt(replaceRainJackets);
		System.out.println("Count of rain jackets:" + rainJacketCount);

		if (totalResults == (jacketCount + rainJacketCount)) {
			System.out.println("The sum of individual categories and total results are equal");
		} else {
			System.out.println("The sum of individual categories and total results are not equal");
		}

		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='brand-more'])")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Search brand'])")).sendKeys("Duke");
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[11]")).click();
		driver.findElement(By.xpath("(//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove'])"))
				.click();
		Thread.sleep(5000);
		int count = 0;
		List<WebElement> brandDukeList = driver.findElements(By.tagName("h3"));
		for (int i = 0; i < brandDukeList.size() - 1; i++) {
			String text = brandDukeList.get(i).getText();
			if (text.contains("Duke")) {
				count++;
			} else {
				System.out.println("The product brand is not Duke");
			}
		}

		System.out.println("Total jackets in Duke brand: " + count);

		WebElement sortBy = driver
				.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']"));
		sortBy.click();
		builder.moveToElement(sortBy).perform();
		Thread.sleep(1000);
		WebElement betterDiscount = driver.findElement(By.xpath("//input[@value='discount']//.."));
		builder.moveToElement(betterDiscount).click().perform();

		String firstJacketPrice = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"))
				.getText();
		System.out.println("Price of first displayed jacket:" + firstJacketPrice);

		driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[1]")).click();

		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));

		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./snaps/FirstJacket-Myntra.png");
		FileUtils.copyFile(src1, dest1);

		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.quit();
	}

}
