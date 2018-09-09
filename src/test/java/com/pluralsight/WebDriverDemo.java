package com.pluralsight;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverDemo {

	public static void main(String[] args) throws  InvalidFormatException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\Software\\chromedriver_win32_1\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","F:\\Software\\geckodriver_64\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		driver.get("https://applysme.barclaycard/gcpap-index.html?PC=1002&MC=COUK01");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		pageOne(wait, driver);
		PageTwo(driver, wait);
		}
	
	
	public static void pageOne(WebDriverWait wait, WebDriver driver) throws InterruptedException
	{
		WebElement selElement=wait.until(ExpectedConditions.elementToBeClickable(By.id("organizationtype")));
		Select sel=new Select(selElement);
		sel.selectByVisibleText("Sole Trader");
		driver.findElement(By.id("business_name")).sendKeys("Business Name Test");
		driver.findElement(By.id("creditcard_name")).sendKeys("Credit Card Name Test");
		driver.findElement(By.id("natureofbusinessFreeText")).sendKeys("Nature of Business");
		driver.findElement(By.id("natureofbusiness")).sendKeys("Plumbing contractor");
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='NatureOfBusiness_search_result']/li[contains(text(),'Plumbing contractor')]")));
		ele.click();
		//Post Code Search
		
		driver.findElement(By.id("postcode")).sendKeys("nn47sg");
		driver.findElement(By.id("address_find")).click();
		Thread.sleep(3000);
		WebElement ele1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='lookup_address_result']/li[contains(text(),'Barclaycard, 1234 Pavilion Drive, NORTHAMPTON NN4 7SG')]")));
		ele1.click();
		
		driver.findElement(By.id("businessTurnoverTwelveMonth")).sendKeys("0");
		driver.findElement(By.id("businessTelNumber")).sendKeys("07881818184");
		Thread.sleep(2000);
		
		//Date Time Picker
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='datepicker hasDatepicker']"))).click();
		Thread.sleep(2000);
        WebElement selElement1=driver.findElement(By.className("ui-datepicker-month"));
        Select sel1=new Select(selElement1);
		sel1.selectByVisibleText("Jan");
		WebElement selElement2=driver.findElement(By.className("ui-datepicker-year"));
		Select sel2=new Select(selElement2);
		sel2.selectByVisibleText("2011");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[4]/a[contains(text(),'5')]"))).click();  
		WebElement selElement3=driver.findElement(By.id("no_of_employees"));
        Select sel3=new Select(selElement3);
		sel3.selectByVisibleText("0 - 25");
		//
		driver.findElement(By.xpath("//a[@id='addCountryBtn']")).click();
		WebElement selElement4=driver.findElement(By.id("countryTradeWith"));
        Select sel4=new Select(selElement4);
		sel4.selectByVisibleText("None of these");
		//
		driver.findElement(By.id("bank_sort_code_input1")).sendKeys("23");
		driver.findElement(By.id("bank_sort_code_input2")).sendKeys("33");
		driver.findElement(By.id("bank_sort_code_input3")).sendKeys("43");
		driver.findElement(By.id("bank_account_number")).sendKeys("455556788");
		driver.findElement(By.xpath("//a[@id='next_button']")).click();
		
	}
	
	public static void PageTwo(WebDriver driver,WebDriverWait wait) throws InterruptedException
	
	{
		//Page 2
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='add_applicant']"))).click();
		WebElement selElement5=driver.findElement(By.id("title_dropdown"));
        Select sel5=new Select(selElement5);
		sel5.selectByVisibleText("Mr");
		
		driver.findElement(By.id("first_name")).sendKeys("FirstName-Test");
		driver.findElement(By.id("middle_name")).sendKeys("MiddleName-Test");
		driver.findElement(By.id("last_name")).sendKeys("LastName-Test");
		
		driver.findElement(By.id("dob_date")).sendKeys("05");
		
		WebElement selElement6=driver.findElement(By.id("dob_month_list"));
        Select sel6=new Select(selElement6);
		sel6.selectByVisibleText("February (02)");
		
		driver.findElement(By.id("dob_year")).sendKeys("1989");
		
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		
		WebElement selElement7=driver.findElement(By.id("nationality"));
        Select sel7=new Select(selElement7);
		sel7.selectByVisibleText("United Kingdom");
		
		driver.findElement(By.xpath("//div[@id='addpartner_controls']/a[contains(text(),'Continue')]")).click();
		
		//Private Address
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(250, 0)");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='isPrivateAddSameContainer']/div/label[contains(text(),'Yes')]"))).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='myDatePicker']"))).click();
        WebElement selElement1=driver.findElement(By.className("ui-datepicker-month"));
        Select sel1=new Select(selElement1);
		sel1.selectByVisibleText("Jan");
		WebElement selElement2=driver.findElement(By.className("ui-datepicker-year"));
		Select sel2=new Select(selElement2);
		sel2.selectByVisibleText("2013");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[3]/a[contains(text(),'1')]"))).click();
		
		driver.findElement(By.xpath("//div/a[@id='add_address_btn']")).click();
		driver.findElement(By.xpath("//div[@id='addpartner_controls']/a[contains(text(),'Continue')]")).click();
		
		//Contact Details
		js.executeScript("scroll(250, 0)");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email_id"))).sendKeys("test@test.com");
		Thread.sleep(2000);
		driver.findElement(By.id("email_id_confirm")).sendKeys("test@test.com");
		driver.findElement(By.id("mobile_no")).sendKeys("07526662555");
		driver.findElement(By.id("home_no")).sendKeys("07898990090");
		driver.findElement(By.id("contact_mail")).click();
		driver.findElement(By.xpath("//div[@id='addpartner_controls']/a[contains(text(),'Continue')]")).click();
		
		driver.findElement(By.xpath("//div[@id='wizards_navigator']/a[@id='next_button']")).click();
		
		driver.findElement(By.xpath("//table[@id='cardholders-table']/tbody/tr[1]/td[4]/label")).click();
		driver.findElement(By.xpath("//div[@id='wizards_navigator']/a[contains(text(),'Continue')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='wizards_navigator']/a[contains(text(),'Continue')]")).click();
		Thread.sleep(2000);
		js.executeScript("scroll(0, 250)");
		
		driver.findElement(By.xpath("//div[@id='wizards_navigator']/a[contains(text(),'Continue')]")).click();
		 
		
		Thread.sleep(1000);
		
		WebElement element=driver.findElement(By.xpath("//div[@class='row sign']/label"));
		 JavascriptExecutor js1 =(JavascriptExecutor)driver;
	        js1.executeScript("window.scrollTo(0,1000)",element);
	        element.click();
	        
	        
		
		
		
		
		
		
}

}
