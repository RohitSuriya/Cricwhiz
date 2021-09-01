package assignments.w4.d1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround_Frames {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement firstFrameElement = driver.findElement(By.xpath("(//div[@id='wrapframe'])[1]/iframe"));
		driver.switchTo().frame(firstFrameElement);
		WebElement clickMeButton = driver.findElement(By.id("Click"));

		File src1 = clickMeButton.getScreenshotAs(OutputType.FILE);
		File tgt1 = new File("./snaps/leafGroundFrames.png");
		FileUtils.copyFile(src1, tgt1);
		driver.switchTo().defaultContent();

		List<WebElement> numberOfFramesList = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of frames in this page: " + numberOfFramesList.size());

	}

}
