package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WallethubPage {
 
	//variables 
	private By inputTextUserName= By.name("em");
	private By inputTextUserPass= By.name("pw");
	private By inputTextUserPass2= By.name("pw1");

	////*[@id="email"]
	private By buttonLogin=By.xpath("//*[@id=\'join-login\']/form/div[4]/button[2]");
	private By buttonLogin2=By.xpath("//*[@id='join-light']/form/div/div[3]/button");

	private By buttonLoginHomePage=By.xpath("//*[@id=\'viewport\']/header/div/nav/div[2]/a[1]");
	private By buttonLoginProfilePage=By.xpath("/html/body/web-app/div/header/div/nav[1]/span[2]");
	private By linkReviews=By.xpath("//*[@id=\'scroller\']/main/div[1]/div[2]/div[2]/div/a");
	

	
	//private By buttonLogin= By.xpath("//input[@id='login']");
	//private By msgLogin= By.xpath("//div[@id='error']/p");
	//private By userButton=By.xpath("//[@id=\'mount_0_0_42\']/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/div/svg/g/image");
	//private By setupUserButton=By.xpath("//*[@id=\'web-app\']/header/div/nav[1]/div[5]/span");
	private By userName=By.xpath("//*[@id=\'scroller\']/main/div[1]/div/div[2]/h1");
	//private By fivestarButton=By.xpath("/html/body/web-app/div/div[1]/main/div[2]/div/div[3]/section/div[2]/div[3]/review-star/div/svg[1]");
	private By onestarButton=By.cssSelector("div.review-stat-box>div.rv.review-action.ng-enter-element>review-star>div>svg:nth-child(1)");
	private By twostarButton=By.cssSelector("div.review-stat-box>div.rv.review-action.ng-enter-element>review-star>div>svg:nth-child(2)");
	private By threestarButton=By.cssSelector("div.review-stat-box>div.rv.review-action.ng-enter-element>review-star>div>svg:nth-child(3)");
	private By fourstarButton=By.cssSelector("div.review-stat-box>div.rv.review-action.ng-enter-element>review-star>div>svg:nth-child(4)");
	private By fivestarButton=By.cssSelector("div.review-stat-box>div.rv.review-action.ng-enter-element>review-star>div>svg:nth-child(5)");

	private By dropBoxHealth=By.xpath("//*[@id=\'reviews-section\']/modal-dialog/div/div/write-review/div[2]/div/ng-dropdown/div/span[1]\r\n");
	private By dropBoxOption=By.xpath("/html/body/web-app/div/div[1]/main/div[2]/div/div[3]/section/modal-dialog/div/div/write-review/div[2]/div/ng-dropdown/div/ul/li[2]");
	
	private By inputTextComment=By.xpath("//*[@id=\'reviews-section\']/modal-dialog/div/div/write-review/div[2]/div/div[1]/textarea\r\n");
	private By submitButton=By.xpath("//*[@id=\'reviews-section\']/modal-dialog/div/div/write-review/sub-navigation/div/div[1]\r\n");

	private By loginTab=By.xpath("//*[@id=\'join-light\']/form/div/nav/ul/li[2]");
	
	private By reviewMsg=By.xpath("//*[@id=\'scroller\']/main/div/div/div[1]/h4");
	private By continueButton=By.xpath("//*[@id=\'scroller\']/main/div/div/div[2]/div/div[3]/div[2]");
	
	private WebDriver driver;

	public WallethubPage(WebDriver driver){
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
		
		//click login homepage button 
		WebElement loginButtonHome = driver.findElement(buttonLoginHomePage);
		//check user 
		Actions builder = new Actions(driver);
		builder.moveToElement(loginButtonHome).click(loginButtonHome);
		builder.perform();		
		
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputTextUserName));
		
		driver.findElement(inputTextUserName).sendKeys(user);
		driver.findElement(inputTextUserPass).sendKeys(pass);
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
		
		//click login button 
		WebElement loginButton = driver.findElement(buttonLogin);
		//check user 
     
        builder.moveToElement(loginButton).click(loginButton);
        builder.perform();
        	
	}
	/*
	public String getLoginMsg() throws InterruptedException{
		
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(msgLogin));

		return driver.findElement(msgLogin).getText();
	}*/
	public String gotoURL(String url) throws InterruptedException{
		 driver.navigate().to(url);
		return driver.getCurrentUrl();

	}
	public String clickStars() throws InterruptedException{
				
		//click four star button
		
		Duration time = Duration.ofSeconds(5);
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(fourstarButton));
		
		WebElement element = driver.findElement(fourstarButton);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
		WebElement myelement = driver.findElement(fourstarButton);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
	        
		return driver.getCurrentUrl();
	
	}
	
	public ArrayList<String> checkStarsHover() throws InterruptedException{
		
		ArrayList<String> listChecked = new ArrayList<String>();
		
		Duration time = Duration.ofSeconds(5);
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(linkReviews));
		
			WebElement linkReview = driver.findElement(linkReviews);
			builder.moveToElement(linkReview).click(linkReview);
	        builder.perform();

	        //star1
			WebElement starButton = driver.findElement(onestarButton);
			builder.moveToElement(starButton); //hover
	        builder.perform();
	        //check fill
	        listChecked.add(starButton.getAttribute("aria-checked"));
	        
	        //star2
	        starButton = driver.findElement(twostarButton);
			builder.moveToElement(starButton);
	        builder.perform();
	        listChecked.add(starButton.getAttribute("aria-checked"));
	        
	        //star3
	        starButton = driver.findElement(threestarButton);
			builder.moveToElement(starButton);
	        builder.perform();
	        listChecked.add(starButton.getAttribute("aria-checked"));
	        
	        //star4
	        starButton = driver.findElement(fourstarButton);
			builder.moveToElement(starButton);
	        builder.perform();
	        listChecked.add(starButton.getAttribute("aria-checked"));
	        
	        //star5
	        starButton = driver.findElement(fivestarButton);
			builder.moveToElement(starButton);
	        builder.perform();
	        listChecked.add(starButton.getAttribute("aria-checked"));
	       
	        /* print list
	        for (int i = 0; i < listChecked.size();i++) 
		      { 		      
		          System.out.println(listChecked.get(i)); 		
		      }*/
	        
		return listChecked;
	
	}
	public String loginFromProfile(String user, String pass) throws InterruptedException{
		//click login profile button 
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);		
		WebElement loginButtonFromProfile = driver.findElement(buttonLoginProfilePage);
				//check user 
				Actions builder = new Actions(driver);
				builder.moveToElement(loginButtonFromProfile).click(loginButtonFromProfile);
				builder.perform();		
				
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(inputTextUserName));
			
			driver.findElement(inputTextUserName).sendKeys(user);
			driver.findElement(inputTextUserPass).sendKeys(pass);
			wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
			
			//click login button 
			WebElement loginButton = driver.findElement(buttonLogin);
			//check user 
	     
	        builder.moveToElement(loginButton).click(loginButton);
	        builder.perform();
	return null;
	}
	public String loginForComment(String user, String pass) throws InterruptedException{
	//click login tab 
		Duration time = Duration.ofSeconds(5);

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginTab));

			WebElement loginTablink = driver.findElement(loginTab);
			//check user 
			Actions builder = new Actions(driver);
			builder.moveToElement(loginTablink).click(loginTablink);
			builder.perform();		
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(inputTextUserName));
			
			driver.findElement(inputTextUserName).sendKeys(user);
			driver.findElement(inputTextUserPass2).sendKeys(pass);
			wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin2));
			
			//click login button 
			WebElement loginButton = driver.findElement(buttonLogin2);
			//check user 
	     
	        builder.moveToElement(loginButton).click(loginButton);
	        builder.perform();
	        	return null;
		}
	
	
	public String postComment(String text) throws InterruptedException{

		Actions builder = new Actions(driver);

		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputTextComment));
		
		driver.findElement(inputTextComment).sendKeys(text);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(dropBoxHealth));
		
	
		WebElement dropBox = driver.findElement(dropBoxHealth);
        builder.moveToElement(dropBox).click(dropBox);
        builder.perform();
        
       	WebElement dropBoxopt = driver.findElement(dropBoxOption);
        builder.moveToElement(dropBoxopt).click(dropBoxopt);
        builder.perform();
        
        WebElement submitComment = driver.findElement(submitButton);
        builder.moveToElement(submitComment).click(submitComment);
        builder.perform();
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(reviewMsg));
        String msg=driver.findElement(reviewMsg).getText();
		return msg;
	
	}
	
	public String getLoginUser() throws InterruptedException{
		
		Duration time = Duration.ofSeconds(5);
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, time);
		        
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		return driver.findElement(userName).getText();
	}
	
	public String checkProfileComments() throws InterruptedException{
		
		/*Duration time = Duration.ofSeconds(5);
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, time);
		        
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		*/
        //TODO que nav al perfil
        //TODO verify que haya un comentario a Test Insurance Company
        return driver.findElement(userName).getText();
	}
	
	

}
	
