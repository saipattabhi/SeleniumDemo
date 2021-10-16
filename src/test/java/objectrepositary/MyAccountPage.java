package objectrepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	 WebDriver driver;
	 public MyAccountPage( WebDriver driver)
	 {
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//*[@class='breadcrumb']//a[text()='Account']")
	private WebElement accountbreadcrumb;
	 
	
	
	
	public WebElement accountbreadcrumb()
	{
		return accountbreadcrumb;
	}
	
	System.out.println("The code has been updated by sai pattabhi ramayya");
	

}
