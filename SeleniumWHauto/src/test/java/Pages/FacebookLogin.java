package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLogin {
 
	//variables 
	private By inputTextUserName= By.name("email");
	private By inputTextUserPass= By.name("pass");
	private By buttonLogin= By.name("login");
	//private By buttonLogin= By.xpath("//input[@id='login']");
	//private By msgLogin= By.xpath("//div[@id='error']/p");
	//*[@id="mount_0_0_42"]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/div/svg/g/image
	private By userButton=By.xpath("//[@id=\'mount_0_0_42\']/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/div/svg/g/image");
	//private By setupUserButton=By.xpath("//*[@id=\'mount_0_0_as\']/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div");
	//private By userName=By.xpath("/html/body/div[3]/div/section/div/nav/ul/div/div[2]/span");
	
	private WebDriver driver;

	public FacebookLogin(WebDriver driver){
		this.driver=driver;
		
	}
	
	/*public void userLoginActionError(String user,String pass){
		driver.findElement(inputTextUserName).sendKeys(user);
		driver.findElement(inputTextUserPassword).sendKeys(pass);
		
		//click login button 
		WebElement loginButton = driver.findElement(buttonLogin);
        Actions builder = new Actions(driver);
        builder.moveToElement(loginButton).click(loginButton);
        builder.perform();

	}*/
	
	public void userLoginActionOk(String user,String pass){
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputTextUserName));
		
		driver.findElement(inputTextUserName).sendKeys(user);
		driver.findElement(inputTextUserPass).sendKeys(pass);
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
		
		//click login button 
		
		WebElement loginButton = driver.findElement(buttonLogin);
		//check user 
        Actions builder = new Actions(driver);
        builder.moveToElement(loginButton).click(loginButton);
        builder.perform();
        	
	}
	/*
	public String getLoginMsg() throws InterruptedException{
		
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(msgLogin));

		return driver.findElement(msgLogin).getText();
	}
	*/
	public String getLoginUser() throws InterruptedException{
		
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(userButton));
		//driver.findElement(userButton).click();
		
		WebElement usermenuButton = driver.findElement(userButton);
		//check user 
        Actions builder = new Actions(driver);
        builder.moveToElement(usermenuButton).click(usermenuButton);
        builder.perform();
      /*  
        WebElement setupMenuUserButton = driver.findElement(setupUserButton);
		//check user 
        builder.moveToElement(setupMenuUserButton).click(setupMenuUserButton);
        builder.perform();
        */
        
        
        //wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		return null;//driver.findElement(userName).getText();
	}
	
	

}
	
