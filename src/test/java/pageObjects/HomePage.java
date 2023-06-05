package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	//WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//For Elemnts
	
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement myAccountLink;//For MyAccount Link
	@FindBy(linkText = "Register") WebElement registerLink;//For Register link
	@FindBy(linkText ="Login") WebElement loginLink;//for Login Link --> added login link in step 6
	//or
	//@FindBy(xpath="//a[normalize-space()='Register']") WebElement registerLink; //For Register link
	
	//Action Methods
	public void myAccount()
	{
		myAccountLink.click();
	}
	
	public void register()
	{
		registerLink.click();
	}
	
	public void login()
	{
		loginLink.click();//added login link in step 6
	}
	
}
