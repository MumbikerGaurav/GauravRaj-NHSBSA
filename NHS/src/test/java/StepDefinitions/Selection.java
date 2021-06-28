package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Selection {
	WebDriver driver =null;

	@Given("^I am a person from Wales$")
	public void PersonFromWales() {
		System.out.print("Person from w=Wales");
		String ProjectPath= System.getProperty("user.dir");
		System.out.println("Project Path is:"+ ProjectPath);
		
		System.setProperty("webdriver.chrome.driver",ProjectPath+"/src/test/resources/Driver/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver",ProjectPath+"/src/test/resources/Driver/geckodriver.exe");	
	}

	@And("^I am able to open the browser and navigate to the NHS url$")
	public void OpenBrowserAndNavigate() {
		driver= new ChromeDriver();
		//driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start");
	}

	@When("^I put my circumstances into the Checker tool (.*) and (.*) and (.*)$")
	public void AddCircumstances(String Date, String Month, String Year) throws InterruptedException {
		
		driver.findElement(By.id("nhsuk-cookie-banner__link_accept_analytics")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//Click start button
		driver.findElement(By.id("next-button")).click();
		Thread.sleep(1000);
		//Select Wales
		driver.findElement(By.id("label-wales")).click();	
        WebElement NextButton = driver.findElement(By.id("next-button"));     	
        js.executeScript("arguments[0].scrollIntoView();", NextButton);
        NextButton.click();
        
        //Add date 
        WebElement daytextbox =driver.findElement(By.id("dob-day"));
        daytextbox.sendKeys(Date);
        Thread.sleep(500);
        WebElement monthtextbox =driver.findElement(By.id("dob-month"));
        monthtextbox.sendKeys(Month);
        Thread.sleep(500);
        WebElement yeartextbox =driver.findElement(By.id("dob-year"));
        yeartextbox.sendKeys(Year);
        Thread.sleep(500);
        NextButton=driver.findElement(By.id("next-button"));
        NextButton.click();
        Thread.sleep(1000);
        
        //Partner selection
        driver.findElement(By.id("label-no")).click(); 
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(1000);
        //Claim benifits
        driver.findElement(By.id("label-no")).click(); 
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(1000);
        //pregnancy
        driver.findElement(By.id("label-no")).click(); 
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(1000);
        //injury
        driver.findElement(By.id("label-no")).click(); 
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(1000);
        //diabetes
        driver.findElement(By.id("label-no")).click(); 
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(1000);
        //glaucoma
        driver.findElement(By.id("label-no")).click(); 
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(1000);
        //carehome
        driver.findElement(By.id("label-no")).click(); 
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(1000);
        //savings
        driver.findElement(By.id("label-no")).click(); 
        driver.findElement(By.id("next-button")).click();
        Thread.sleep(1000);
	}

	
	@Then("^I should get a result of whether I will get help or not$")
	public void GetResults() 
	{
		if(driver.getPageSource().contains("You get help with NHS costs"))
			{
			System.out.println("You get help with NHS costs");
			}
		else
			{
			System.out.println("You will not get help with NHS costs");
			}
	// close the web browser
       driver.close();
       System.out.println("Test script executed successfully.");	

	}

}
