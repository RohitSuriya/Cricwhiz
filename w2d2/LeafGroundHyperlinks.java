package assignments.w2d2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundHyperlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.partialLinkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
		
		String buttonLink = driver.findElement(By.xpath("//a[contains(text(),'Find where am supposed to go without clicking me?')]")).getAttribute("href");
		System.out.println("The link of the expected page is: " +  buttonLink);
	
		WebElement errorLink = driver.findElement(By.xpath("//a[contains(text(),'Verify am I broken?')]"));
		String url = errorLink.getAttribute("href");
		HttpURLConnection c=(HttpURLConnection)new URL(url).openConnection();
		c.setRequestMethod("HEAD");
		c.connect();
		int responseCode = c.getResponseCode();
		System.out.println("The response code is: " + responseCode);
		
		if(responseCode >= 400) {
			System.out.println("The link is broken");
		}
			
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Home Page')])[2]")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();

		List<WebElement> links = driver.findElements(By.tagName("a"));
	    System.out.println("The number of links in the page is: "+ links.size());
		
		
		
	}

}
