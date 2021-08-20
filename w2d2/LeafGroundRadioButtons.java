package assignments.w2d2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundRadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='yes']")).click();
		
		WebElement radioButton1 = driver.findElement(By.xpath("(//input[@name='news'])[1]"));
		boolean isSelected = radioButton1.isSelected();
		System.out.println(isSelected);
		if(isSelected) {
			String text = radioButton1.getText();
			System.out.println("The selected radio button is " + text);
		}else {
			String text1 = driver.findElement(By.xpath("(//label[@for='Checked'])[1]")).getText();
			System.out.println("The selected radio button is " + "'" + text1 + "'" );
		}
		
		boolean selected = driver.findElement(By.xpath("(//input[@name='age'])[2]")).isSelected();
		if(!selected) {
			driver.findElement(By.xpath("(//input[@name='age'])[2]")).click();
		}
		
				
	}

}
