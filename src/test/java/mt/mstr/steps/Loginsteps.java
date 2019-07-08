package mt.mstr.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import mt.mstr.config.Config;

public class Loginsteps
{
	public static WebDriver driver;
	
	@When ("^user opens \"(.*)\" browser$")
    public void openBrowser(String browsernm)
    {
    	if(browsernm.equalsIgnoreCase("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver","F:\\Selenium Setup\\setup1\\4052019\\chromedriver_win32 (22)\\chromedriver.exe");
    		Config.driver =new ChromeDriver();
    		System.out.println("Chrome browser is opened successfully");
    		System.out.println("Git updated in chrome");
    		System.out.println("git changes==========");
    	
    		
    	}else if(browsernm.equalsIgnoreCase("ie"))
    	{
    		System.setProperty("webdriver.ie.driver", "F:\\Selenium Setup\\setup1\\4052019\\IEDriverServer_x64_3.14.0 (12)\\IEDriverServer.exe");
    		Config.driver=new InternetExplorerDriver();
    		System.out.println("IE browser is opened successfully");
    		System.out.println("Git updated in IE browser");
    		System.out.println("Git In Ie");
   
    	}else
    	{
    		System.setProperty("webdriver.gecko.driver","F:\\Selenium Setup\\setup1\\4052019\\geckodriver-v0.24.0-win64\\geckodriver.exe");
    		Config.driver = new FirefoxDriver();
    		System.out.println("Firefox browser is opened successfully");
    	}
    }
	
	@And ("^user enters application url as \"(.*)\"$")
	  public void enterApplicationURL(String url)
	  {
		  Config.driver.get(url);
	  }
	
	
	@And ("^user waits \"(.*)\" seconds to Login page to be loaded$")
	public void waittillLoginpageloaded(int timeoutseconds)
	{
		Config.driver.manage().timeouts().pageLoadTimeout(timeoutseconds, TimeUnit.SECONDS);
		
	}
	
	@And ("^user maximizes browser$")
	public void maximizeBrowser()
	{
		Config.driver.manage().window().maximize();
	}
	
	
	@Then ("^user is on Login page of Mercury Tours application$")
	public void verifyLoginpagetitle()
	{
		String Title=Config.driver.getTitle();
		System.out.println("Title of login page" +Title);
	}
	
	@Given ("^user is on login page of Mercury Tours application$")
	public void verifyLoginpage()
	{
		String url=Config.driver.getCurrentUrl();
		System.out.println("Current url is:"+url);
	}
	
	@When ("^user enters \"(.*)\" as username$")
	public void enterUsername(String username)
	{
		Config.driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	}
	
	@And ("^user enters \"(.*)\" as password$")
	public void enterPassword(String password)
	{
		Config.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}
	
	@And ("^user clicks on Sign In button$")
	public void clickonSignIn()
	{
		 Config.driver.findElement(By.xpath("//input[@name='login']")).click();
	}
	
	@Then ("^user is on Flight Finder page$")
	public void verifyFlightfinder()
	{
	  boolean act_flag1= Config.driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  System.out.println("Flight Finder image is displayed");
	  
	  
	}
	
	@When ("^user clicks on Sign off link$")
	public void clickonSignoff()
	{
		Config.driver.findElement(By.linkText("SIGN-OFF")).click();
	}
	
	@Then ("^User access Sign on page$")
	public void verifySignonpage()
	{
		boolean act_flag3=Config.driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
		if(act_flag3==true)
		{
			System.out.println("User is on Sign on page");
		}
	}
	
	
	
	
	
	
	
	
}
