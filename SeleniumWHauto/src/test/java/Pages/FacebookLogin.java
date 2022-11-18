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
	private By userButton=By.xpath("//[@id=\'mount_0_0_42\']/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/div/svg/g/image");
	
	private WebDriver driver;

	public FacebookLogin(WebDriver driver){
		this.driver=driver;
		
	}
	
		
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
	
	public String getLoginUser() throws InterruptedException{
		
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(userButton));
		
		WebElement usermenuButton = driver.findElement(userButton);
		//check user 
        Actions builder = new Actions(driver);
        builder.moveToElement(usermenuButton).click(usermenuButton);
        builder.perform();
  		return null;//driver.findElement(userName).getText();
	}
	
	

}
	
