package Tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import Pages.WallethubPage;
import junit.framework.Assert;

public class WallethubTests {
	
	//PRECONDITIONS:
	//go to https://wallethub.com/join/light
	//uncheck get free..
	//create USER /walletHub_1/
	//verify mail
	//use in login

	WebDriver driver;
	String PATH_DRIVER= "./src/test/resources/driver/chromedriver.exe";
	
	String TYPE_DRIVER= "webdriver.chrome.driver";
	String URL="https://www.wallethub.com";
	//String URL="https://www.wallethub.com/profile/13732055i";
	Pages.WallethubPage wallethubPage;
	String user="rbarbosait@gmail.com";
	String pass="walletHub_1";
	
	//String PATH_USERFILE= "./src/test/resources/userCredentials/userDoc.txt";


	@BeforeMethod
	public void setup(){
		
		/*//read user&pass
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
		
		*/
		System.setProperty(TYPE_DRIVER, PATH_DRIVER);
		ChromeOptions options = new ChromeOptions();
		
		//disable notifications-------------
		options.addArguments("--disable-notifications");
		//headless-------------
		//options.addArguments("--headless");
		driver= new ChromeDriver(options);
		

		driver.manage().window().maximize();
		driver.get(URL);
		wallethubPage=new WallethubPage(driver);
		
	}
	/*
	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void testLoginOk(){
		wallethubPage.userLoginActionOk(user, pass);

		//verify
		
		try {
			//System.out.println(wallethubPage.getLoginUser());
			String[] userName = user.split("\\@");
			user=userName[0];
			Assert.assertEquals(user,wallethubPage.getLoginUser());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void testUrlNavigation(){
		//wallethubPage.userLoginActionOk(user, pass);
		String url2="https://wallethub.com/profile/13732055i";
		String returned="https://wallethub.com/profile/test-insurance-company-13732055i";
	
		
		//verify
		
		
		try {
			//System.out.println(wallethubPage.gotoURL(url2));
			Assert.assertEquals(returned,wallethubPage.gotoURL(url2));
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}*/
	
	@Test(priority=3)
	public void testPostComment() throws Throwable{
		String url2="https://wallethub.com/profile/13732055i";
		String urlReview="https://wallethub.com/profile/test-insurance-company-13732055i#reviews";
		String successMsg="Your review has been posted.";
		String urlProfile="https://wallethub.com/profile/69288224i";
		String reviewProfileName="Test Insurance Company";
		
		wallethubPage.gotoURL(url2);
		wallethubPage.loginFromProfile(user, pass);
		
		
		ArrayList<String> listCheckedVerify = new ArrayList<String>(Arrays.asList("true", "true", "true", "true", "true"));
		//wallethubPage.clickStars();
		
		//verify hover
				try {
					Assert.assertEquals(listCheckedVerify,wallethubPage.checkStarsHover());
				} catch (AssertionError e) {
					
					e.printStackTrace();
				}
		//verify star click redirect
		try {
			Assert.assertEquals(urlReview,wallethubPage.clickStars());
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		try {
			Assert.assertEquals(successMsg,wallethubPage.postComment("Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB--Test_RB"));
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}	
		
		wallethubPage.gotoURL(urlProfile);

		wallethubPage.checkProfileComments();
		
		
		//wallethubPage.loginForComment(user, pass);

		//String expListName=boardPage.getListName();
		
		//verify
		/*try {
			Assert.assertEquals(expListName,boardPage.getListaName());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}*/
	}
	
	
	/*@After
	public void closeNav(){
		driver.quit();
	}*/
	
	//@AfterMethod(alwaysRun = true)
	// si error - foto
	//else quit
	/*public void takeScs(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			Utility.Screenshot.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}*/
}
