package assignments.w2d2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImages {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.findElement(By.xpath("//img[@alt='Images']")).click();

		WebElement brokenImage = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']"));
		String url = brokenImage.getAttribute("src");
		HttpURLConnection c = (HttpURLConnection) new URL(url).openConnection();
		c.setRequestMethod("HEAD");
		c.connect();
		int responseCode = c.getResponseCode();
		System.out.println("The response code is: " + responseCode);

		if (responseCode >= 400) {
			System.out.println("The image is broken");
		}

		driver.findElement(By.xpath("//img[@src='../images/keyboard.png']")).click();
		driver.findElement(By.xpath("//img[@alt='Images']")).click();

		driver.close();
	}

}
