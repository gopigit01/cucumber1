package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {

	public void loginlink(WebDriver d1)
	{
		d1.findElement(By.xpath("//p[normalize-space()='Login or Create Account']")).click();
	}
	
	public WebElement EmailorMobileNumber(WebDriver d1)
	{
		return d1.findElement(By.xpath("//input[@id='username']"));
	}
	public void ContinueButton(WebDriver d1)
	{
		d1.findElement(By.xpath("//button[contains(@class,'capText font16')]")).click();
	}
	public void Password(WebDriver d1)
	{
		d1.findElement(By.id("password"));
	}
	
	public void LoginButton(WebDriver d1)
	{
		d1.findElement(By.xpath("//button[@class='capText font16']")).click();
	}
	
	public static WebElement RegAddButton(WebDriver d1)
	{
		return d1.findElement(By.xpath("//input[@title='Add']"));
	}
	
	@FindBy(xpath="//input[@title='Add']")
	public static WebElement RegAddButton;
	
	
	
	//d1.findElement(By.id("userName")).sendKeys(un);
	//@FindBy(xpath="//label[@for='userName']")
	@FindBy(xpath="//*[@id='userName']")
	public static WebElement DataDrivenInvlaidUserName; //DataDrivenInvlaid Login name Locaters
	
	//@FindBy(xpath="//label[@for='password']")
	@FindBy(xpath="//*[@id='password']")
	public static WebElement DataDrivenInvlaidPassword; //DataDrivenInvlaid Login password Locaters
	
	//@FindBy(xpath="submitBtn")
	@FindBy(xpath="//*[@id='submitBtn']")
	public static WebElement DataDrivenInvlaidSubmit; //DataDrivenInvlaid Login submit Locaters
	
	
	/* login locaters */		//*[@id="userName"] //*[@id="password"]  //*[@id="submitBtn"]
	
	@FindBy(xpath="//*[@id='userName']") // login locaters
	public static WebElement LoginUserName; // login locaters
	
	@FindBy(xpath="//*[@id='password']")
	public static WebElement LoginPassword; //login locaters
	
	@FindBy(id="submitBtn") 				//login locaters
	public static WebElement LoginSubmit; 
	
	/*    UptoPaymentPage Locaters                   */
	
	
	@FindBy(name="userName") 
	public static WebElement UptoPaymentUserName; 
	
	@FindBy(name="password")
	public static WebElement UptoPaymentPassword; 
	
	@FindBy(id="submitBtn") 				
	public static WebElement UptoPaymentsubmitBtn; 
	
	@FindBy(id="fromPlaceName") 				
	public static WebElement UptoPaymentFromPlace;
	
	@FindBy(id="toPlaceName") 				
	public static WebElement UptoPaymentToPlace;
	
	@FindBy(xpath="//button[normalize-space()='Search for Bus']") 				
	public static WebElement UptoPaymentSerachBusButton;
	
	@FindBy(id="passengerNameForward0") 				
	public static WebElement UptoPaymentPassengerName;
	
	@FindBy(id="passengerAgeForward0") 				
	public static WebElement UptoPaymentPassengerAge;
	
	@FindBy(id="PgBtn") 				
	public static WebElement UptoPaymentPageButton;
	
	// RegPage
	
	@FindBy(xpath="//input[@title='Add']") 				
	public static WebElement RegSuccbutton;
	
	// SearcInvalidLoc/ or Valid Loc
	
	@FindBy(name="userName") 				
	public static WebElement SearcInvalidPageUserName;
	
	@FindBy(name="password") 				
	public static WebElement SearcInvalidPageUserPassword;
	
	@FindBy(id="submitBtn") 				
	public static WebElement SearcInvalidPagesubmitBtn;
	
	@FindBy(id="fromPlaceName") 				
	public static WebElement SearcInvalidPagefromPlaceName;
	
	@FindBy(id="toPlaceName") 				
	public static WebElement SearcInvalidPageToPlaceName;
	
	@FindBy(xpath="//button[normalize-space()='Search for Bus']") 				
	public static WebElement SearcInvalidPageClick;
	
	
}
