package assignments.w2d1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		// Verify if the landing page is correct - My Home | opentaps CRM
		String landPageExp = "My Home | opentaps CRM";
		String landPageAct = driver.getTitle();

		if (landPageExp.equals(landPageAct)) {
			System.out.println("The page loaded is the home page");
		} else {
			System.out.println("Page loaded is not expected");
		}
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Accy");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Bat");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Man");

		WebElement sourceDropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select drop1 = new Select(sourceDropDown);
		drop1.selectByIndex(7);

		WebElement marketCampaignDropDown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select drop2 = new Select(marketCampaignDropDown);
		drop2.selectByValue("CATRQ_AUTOMOBILE");

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Bat");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("man");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mr");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("01/1/90");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Mr");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Technical");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("100000000");

		WebElement preferredCurrency = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select drop3 = new Select(preferredCurrency);
		drop3.selectByValue("USD");

		WebElement industryDropDown = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select drop4 = new Select(industryDropDown);
		drop4.selectByVisibleText("Non-profit");

		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("500");

		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select drop5 = new Select(ownership);
		drop5.selectByIndex(1);

		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("619A");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("Green");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Create test lead dscription");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Create test lead important note");

		WebElement countryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		countryCode.clear();
		countryCode.sendKeys("7");

		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("Area51");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("0123456789");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("+91");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Batman");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@tesleaf.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://create-testlead.com");

		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Dark Knight");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Batman");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("619, Gotham");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Nowhere");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Gotham");

		WebElement country = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select drop6 = new Select(country);
		String actualCountry = "United States";
		if (drop6.equals(actualCountry)) {
			WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select drop7 = new Select(state);
			drop7.selectByIndex(10);
		} else {
			drop6.selectByValue("USA");
			WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select drop8 = new Select(state);
			drop8.selectByIndex(10);
		}

		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("123456");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("a");

		driver.findElement(By.className("smallSubmit")).click();
		String expectedPageTitle = "View Lead | opentaps CRM";
		String actualPageTitle = driver.getTitle();
		
		if(actualPageTitle.equals(expectedPageTitle)) {
			System.out.println("The lead profile/account created successfully");
		}else {
			System.out.println("There has been some error with the lead profile/account creation");
		}
	}

}
