package step_package;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class step_class {
   WebDriver driver;
	@Given("^Open mailrediff application$")
	public void open_mailrediff_application() throws Throwable {
		System.setProperty("webDriver.chrome.driver", "\"C:\\chormeDriver\\chrome-win64\\chrome.exe\"");
		 ChromeOptions naz= new ChromeOptions();
		 naz.addArguments("--remote-allow-origins=*");
		 
		 driver= new ChromeDriver();
		 //driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		 //driver.get("https://www.southwest.com/");
		 driver.get("https://www.paychex.com/login");
		 driver.manage().window().maximize();
		 //Thread.sleep(2000);
		 
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
	}

	@Then("^Enter username$")
	public void enter_username() throws Throwable {
		
	    WebElement usr = driver.findElement(By.id("login1"));
	    usr.sendKeys("nazmin");
	}

	@Then("^Click log in$")
	public void click_log_in() throws Throwable {
		WebElement lg = driver.findElement(By.name("proceed"));
		lg.click();
		driver.switchTo().alert().accept();     //handle the popup alert
		
	    
	}

	@Then("^Enter depature date$")
	public void enter_depature_date() throws Throwable {
		
		                                 //this is the way we can work with celender
		((JavascriptExecutor)driver).executeScript("scroll(0,500)");
		
		JavascriptExecutor date= (JavascriptExecutor)driver;
		date.executeScript("document.getElementById('LandingAirBookingSearchForm_departureDate').value='09/15/2023'");
		date.executeScript("document.getElementById('LandingAirBookingSearchForm_returnDate').value='09/20/2023'");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Then("^Click on login page to go another page$")
	public void click_on_login_page_to_go_another_page() throws Throwable {
	   
		WebElement lgn = driver.findElement(By.xpath("//a[text()='Paychex Flex login']"));
		lgn.click();
		                             // way to multiple window handle
        Set<String>	allwnd	= driver.getWindowHandles();
        Iterator<String> ite = allwnd.iterator();
        String parentwindow = ite.next();
        String childwindow = ite.next();
        
        driver.switchTo().window(childwindow);
        System.out.println("i am in child window");
        Thread.sleep(3000);
        driver.switchTo().window(parentwindow);
        System.out.println("i am in parent window");
        
        Thread.sleep(3000);
        driver.quit();
         
	}


	
	}



