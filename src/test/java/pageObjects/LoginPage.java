package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//For Elements
	@FindBy(id ="input-email") WebElement txtEmail_Id;//for email id
	@FindBy(id ="input-password") WebElement txtPassword;// for password
	@FindBy(xpath="//input[@value='Login']")WebElement btnLogin;// for login button
	
	//For Action Methods
	
	public void setEmail(String email)
	{
		txtEmail_Id.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void Clicklogin()
	{
		btnLogin.click();
	}
}
