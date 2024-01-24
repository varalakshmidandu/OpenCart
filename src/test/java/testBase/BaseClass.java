package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;//for read config.properties file

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//for Logger
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public ResourceBundle rb;// to read config.properties
	
	/*ExtentReportManager will not get the driver,
	bcoz we are not extends BaseClass into ExtentReportManager class
	still we need to get driver so we will make WebDriver static then 
	we will access driver in every where (for all objects and classes)*/
	public static WebDriver driver;
	public Logger logger;
	
	//@Before and @After these methods are TesNG annotations we cannot call any where
	
	@BeforeClass(groups = { "Master", "Sanity", "Regression" })//groups addesStep 8
	@Parameters("browser")   // getting browser parameter from testng.xml
	public void SetUp(String br)
	{
		rb = ResourceBundle.getBundle("config");// Load config.properties
		//log4j code
		logger = LogManager.getLogger(this.getClass());
		//launch right browser based on parameter
				if (br.equalsIgnoreCase("chrome"))
				{
					logger.info("Launching chrome browser");
					//when we launch browse we can see chrome is being automated,using these options we will avoid that
					ChromeOptions options= new ChromeOptions();
					options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
					driver = new ChromeDriver(options);
				} 
				else if (br.equalsIgnoreCase("edge")) 
				{
					logger.info("Launching edge browser");
					driver = new EdgeDriver();
				} else {
					driver = new ChromeDriver();
				}	
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://localhost/opencart/upload/index.php");   // local app URL
		//driver.get("https://tutorialsninja.com/demo/");   // live App URL
		logger.info("Launching the browser");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups = { "Master", "Sanity", "Regression" })//groups addesStep 8
	public void tearDown()
	{
		logger.info("Closing the application");
		driver.quit();
	}
	//reusable methods
	//Java methods -- we can call these methods any where (any class or tests)
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	//tname is name of the test 
	//we have to save the screenshots with the timestamp
	/*when ever you capture the screenshot we have to save with the name
	and name should contains the timestamp*/
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination; // location and path of the Screenshots

	}
}
