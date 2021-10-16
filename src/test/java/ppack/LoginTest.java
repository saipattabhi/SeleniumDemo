package ppack;

import java.util.concurrent.TimeUnit;

import javax.accessibility.AccessibleEditableText;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepositary.LoginPage;
import objectrepositary.MyAccountPage;



public class LoginTest {
	WebDriver driver;
	ExtentReports extend;
	
	@BeforeMethod
	public void configuration()
	{
		String filepath = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(filepath);
		reporter.config().setReportName("Page object Refract Model");
		reporter.config().setDocumentTitle("Page Object Model");
		 extend=new ExtentReports();
		extend.attachReporter(reporter);
		extend.setSystemInfo("Operatingsystem", "WIndows 10");
		extend.setSystemInfo("Tested By", "sai pattabhi");
	}
	
	
	@Test
	public void login() throws Exception
	{
		ExtentTest etext = extend.createTest("Login started");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 etext.info("Chrome driver started sucessfully ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.get("http://tutorialsninja.com/demo/index.php?route=account%2Flogin");
	etext.info("Navigated to required application");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.emailfield().sendKeys("saipattabhi18@gmail.com");
		loginpage.passwordfield().sendKeys("sai@2255");
		loginpage.loginButton().click();
		
		MyAccountPage myAccountPage=new MyAccountPage(driver);
		Assert.assertTrue(myAccountPage.accountbreadcrumb().isDisplayed());
		System.out.println("Newly updated page");
		
		Thread.sleep(3000);



		 
		
	}
	@AfterMethod
	public void closure()
	{
	driver.close();
	extend.flush();
	}

}
