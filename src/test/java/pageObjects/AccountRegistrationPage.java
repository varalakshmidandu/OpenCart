package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	//WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//For Elements
	
	@FindBy(name = "firstname")WebElement txtFirstName;//for first name
	@FindBy(name = "lastname")WebElement txtLastName; //for Last name
	@FindBy(name = "email")WebElement txtEmail; //for E-mail
	@FindBy(name = "telephone")WebElement txtTelephone; //for Telephone number
	@FindBy(name = "password")WebElement txtPassword;//For Password
	@FindBy(name = "confirm")WebElement txtConfirmPassword;//For Confirm Password
	@FindBy(name = "agree")WebElement chkdPolicy;//For check box policy
	@FindBy(name = "newsletter")WebElement radiobtnNewsletter; //For radio button subscription
	@FindBy(xpath = "//input[@value='Continue']")WebElement btnContinue; //For continue button
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgConfirmation;//For message confirmation after clicking continue button
	
	
	//Methods
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);

	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);

	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);

	}

	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);

	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	}

	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);

	}

	public void setPrivacyPolicy() {
		chkdPolicy.click();

	}

	public void clickContinue() {
		btnContinue.click();
	}
	public String getConfirmationMsg()
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());//if any exception occur exception name should display
		}
	}
	
}
