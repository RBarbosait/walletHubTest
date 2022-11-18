package Tests;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.FacebookLogin;
import junit.framework.Assert;

public class FacebookTests {

	WebDriver driver;
	String PATH_DRIVER= "./src/test/resources/driver/chromedriver.exe";
	
	String TYPE_DRIVER= "webdriver.chrome.driver";
	String URL="https://www.facebook.com/";
	Pages.FacebookLogin facebookPage;
	String user;
	String pass;
	
	String PATH_USERFILE= "./src/test/resources/userCredentials/userDoc.txt";


	@BeforeMethod
	public void setup(){
		
		//read user&pass
		try {
			String[] userNamePass = Utility.ReadDoc.readDocumentInfo(PATH_USERFILE).split("\\n+");
			System.out.println(userNamePass[0]);
			user=userNamePass[0];
			pass=userNamePass[1];
			//System.out.println(Utility.ReadDoc.readDocumentInfo(PATH_USERFILE));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.setProperty(TYPE_DRIVER, PATH_DRIVER);
		ChromeOptions options = new ChromeOptions();
		
		//disable notifications-------------
		options.addArguments("--disable-notifications");
		//headless-------------
		//options.addArguments("--headless");
		driver= new ChromeDriver(options);
		

		driver.manage().window().maximize();
		driver.get(URL);
		facebookPage=new FacebookLogin(driver);
		
	}
	
	@Test(priority=1)
	public void testLoginOk(){
		facebookPage.userLoginActionOk(user, pass);

	
}}
