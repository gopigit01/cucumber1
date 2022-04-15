package script;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.Elements;

public class Steps {

	WebDriver d1;

	@Given("open chrome browser & url of the appln")
	public void open_chrome_browser_url_of_the_appln() throws IOException {

		FileInputStream fi = new FileInputStream(
				"D:\\SeleniumPractice\\Selenium_Project\\src\\test\\java\\webdriverpack\\Config.properties");
		Properties prop = new Properties();
		prop.load(fi);
		String browser = prop.getProperty("browser_name");
		String path = prop.getProperty("driver_path");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path);
			d1 = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", path);
			d1 = new FirefoxDriver();
		}

		else {
			System.setProperty("webdriver.ie.driver", path);
			d1 = new InternetExplorerDriver();
		}
		// WebDriver d1= new FirefoxDriver();
		d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d1.manage().window().maximize();

	}

	@When("enter teh invalidusername and invalidpassword and click ok")
	public void enter_teh_invalidusername_and_invalidpassword_and_click_ok() throws IOException {

		FileInputStream f1 = new FileInputStream("D:\\General\\Reports\\XLSX\\Test3.xlsx");
		XSSFWorkbook w2 = new XSSFWorkbook(f1);
		XSSFSheet s2 = w2.getSheetAt(0);
		PageFactory.initElements(d1, Elements.class);

		for (int i = 1; i < s2.getLastRowNum(); i++) {

			XSSFRow current_cell = s2.getRow(i);
			String un = current_cell.getCell(0).getStringCellValue();
			String pw = current_cell.getCell(1).getStringCellValue();

			d1.get("https://ksrtc.in/oprs-web/login/show.do");
			// PageFactory.initElements(d1, Elements.class);
			// d1.findElement(By.id("userName")).sendKeys(un);
			// d1.findElement(By.name("password")).sendKeys(pw);
			// d1.findElement(By.id("submitBtn")).click();//D:\General\Reports\XLSXD:\General\Reports\XLSX

			// defined object repository
			Elements.DataDrivenInvlaidUserName.sendKeys(un);
			Elements.DataDrivenInvlaidPassword.sendKeys(pw);
			Elements.DataDrivenInvlaidSubmit.click();
		}

		TakesScreenshot t1 = (TakesScreenshot) d1;
		File source = t1.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\SeleniumPractice\\Selenium_Project\\ScreenShots\\InvalidLoginScreen2.jpg");
		org.openqa.selenium.io.FileHandler.copy(source, dest);

	}

	@Then("login unsuccess")
	public void login_unsuccess() {
		d1 = new FirefoxDriver();
		d1.close();
	}

	// valid login
	@Given("opn chrome browser & url of the application")
	public void opn_chrome_browser_url_of_the_application() {
		WebDriverManager.firefoxdriver().browserVersion("98.0.2").setup();
		WebDriver d1;

		d1 = new FirefoxDriver();
		d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageFactory.initElements(d1, Elements.class);
		d1.get("https://ksrtc.in/oprs-web/login/show.do");
		d1.manage().window().maximize();

	}

	@When("enter teh invalidusername and validpassword and click ok")
	public void enter_teh_invalidusername_and_validpassword_and_click_ok() {
		Elements.LoginUserName.sendKeys("gopikrishnagns@gmail.com");
		Elements.LoginPassword.sendKeys("Eshi@123");
		Elements.LoginSubmit.click();

	}

	@Then("login success")
	public void login_success() {
		d1 = new FirefoxDriver();
		d1.quit();

	}

	// Reg-Invald

	@Given("open chr browser & url of the appln")
	public void open_chr_browser_url_of_the_appln() {

		WebDriverManager.firefoxdriver().browserVersion("98.0.2 ").setup();
		d1 = new FirefoxDriver();

		d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d1.get("https://ksrtc.in/oprs-web/user/add.do");
		d1.manage().window().maximize();

	}

	@When("enter teh invalidRegusername and invalidpassword and click ok")
	public void enter_teh_invalid_regusername_and_invalidpassword_and_click_ok() throws IOException {
		PageFactory.initElements(d1, Elements.class);

		JavascriptExecutor jse = (JavascriptExecutor) d1;
		jse.executeScript("document.getElementById('email').value='gopikrishnagnsty1234@gmail.com'"); // fullName
		jse.executeScript("document.getElementById('fullName').value='GGG'");

		TakesScreenshot t1 = (TakesScreenshot) d1;
		File source = t1.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\SeleniumPractice\\Selenium_Project\\ScreenShots\\FailRegScreen1.jpg");
		org.openqa.selenium.io.FileHandler.copy(source, dest);

		jse.executeScript("document.getElementById('mobileNo').value='1231231234'");

		// d1.findElement(By.xpath("//input[@title='Add']")).click();
		Elements.RegAddButton.click();
	}

	@Then("Reg unsuccess")
	public void reg_unsuccess() {

		d1 = new FirefoxDriver();
		d1.close();
	}

	@Given("open chr brws & url of the appln")
	public void open_chr_brws_url_of_the_appln() {
		WebDriverManager.firefoxdriver().browserVersion("98.0.2 ").setup();
		WebDriver d1 = new FirefoxDriver();

		d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// d1.get("https://ksrtc.in/oprs-web/"); //div.form-label-group:nth-child(2) >
		// label:nth-child(2)
		d1.get("https://ksrtc.in/oprs-web/user/add.do");
		d1.manage().window().maximize();

	}

	@When("enter the VlidRegusername and Validpassword and click ok")
	public void enter_the_vlid_regusername_and_validpassword_and_click_ok() {
		d1 = new FirefoxDriver();
		// PageFactory.initElements(d1, Elements.class);
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor)d1; jse.executeScript(
		 * "document.getElementById('email').value='gopikrishnagnsty12345@gmail.com'");
		 * // fullName
		 * jse.executeScript("document.getElementById('fullName').value='GGG'");
		 * jse.executeScript("document.getElementById('mobileNo').value='6786787892'");
		 */
		d1.findElement(By.id("#email")).sendKeys("gopikrishnagnsty12345@gmail.com");
		d1.findElement(By.id("#fullName")).sendKeys("GGGGG");
		d1.findElement(By.id("#mobileNo")).sendKeys("6786787812");

	}

	@Then("Regt success")
	public void regt_success() {
		d1 = new FirefoxDriver();
		d1.close();

	}

	@Given("open FF browser & url of the appln")
	public void open_ff_browser_url_of_the_appln() {

		WebDriverManager.firefoxdriver().browserVersion("98.0.2 ").setup();

		d1 = new FirefoxDriver();
		d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// d1.get("https://ksrtc.in/oprs-web/");

		d1.get("https://ksrtc.in/oprs-web/login/show.do");
		d1.manage().window().maximize();
	}

	@When("enter the serachLocation and click ok")
	public void enter_the_serach_location_and_click_ok() throws InterruptedException, IOException {
		PageFactory.initElements(d1, Elements.class);
		// d1.findElement(By.name("userName")).sendKeys("gopikrishnagns@gmail.com");
		Elements.SearcInvalidPageUserName.sendKeys("gopikrishnagns@gmail.com");
		Thread.sleep(1000);
		// d1.findElement(By.name("password")).sendKeys("Eshi@123");
		Elements.SearcInvalidPageUserPassword.sendKeys("Eshi@123");
		// d1.findElement(By.id("submitBtn")).click();
		Elements.SearcInvalidPagesubmitBtn.click();
		// d1.findElement(By.id("fromPlaceName")).sendKeys("MYSOR");
		Elements.SearcInvalidPagefromPlaceName.sendKeys("MYSOR");
		// Thread.sleep(1000);
		// d1.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
		Elements.SearcInvalidPagefromPlaceName.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		// d1.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);
		Elements.SearcInvalidPagefromPlaceName.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// d1.findElement(By.id("toPlaceName")).sendKeys("HHHHHHHHHH%%%");
		Elements.SearcInvalidPageToPlaceName.sendKeys("HHHHHHHHHH%%%");
		Thread.sleep(1000);
		TakesScreenshot t1 = (TakesScreenshot) d1;
		File source = t1.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\SeleniumPractice\\Selenium_Project\\ScreenShots\\SerachInvalidLocScreen1.jpg");
		org.openqa.selenium.io.FileHandler.copy(source, dest);

	}

	@Then("invalidserchLocation error message")
	public void invalidserch_location_error_message() {

		d1.quit();
	}

	@Given("opn FFox browser & url of the appln")
	public void opn_f_fox_browser_url_of_the_appln() {
		WebDriverManager.firefoxdriver().browserVersion("98.0.2").setup();
		// WebDriver d1;
		d1 = new FirefoxDriver();
		d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d1.get("https://ksrtc.in/oprs-web/login/show.do");
		d1.manage().window().maximize();

	}

	@When("enter the validserachLocation and click ok")
	public void enter_the_validserach_location_and_click_ok() throws IOException, InterruptedException {

		PageFactory.initElements(d1, Elements.class);
		// d1.findElement(By.name("userName")).sendKeys("gopikrishnagns@gmail.com");
		Elements.SearcInvalidPageUserName.sendKeys("gopikrishnagns@gmail.com");
		Thread.sleep(1000);
		// d1.findElement(By.name("password")).sendKeys("Eshi@123");
		Elements.SearcInvalidPageUserPassword.sendKeys("Eshi@123");
		// d1.findElement(By.id("submitBtn")).click();
		Elements.SearcInvalidPagesubmitBtn.click();
		// d1.findElement(By.id("fromPlaceName")).sendKeys("MYSOR");
		Elements.SearcInvalidPagefromPlaceName.sendKeys("MYSOR");
		// Thread.sleep(1000);
		// d1.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		// d1.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);
		Elements.SearcInvalidPagefromPlaceName.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		// d1.findElement(By.id("toPlaceName")).sendKeys("TIRUPATHI");
		Elements.SearcInvalidPageToPlaceName.sendKeys("TIRUPATHI");
		Thread.sleep(1000);
		// d1.findElement(By.id("toPlaceName")).sendKeys(Keys.DOWN);
		// Thread.sleep(1000);
		// d1.findElement(By.id("toPlaceName")).sendKeys(Keys.ENTER);
		Elements.SearcInvalidPageToPlaceName.sendKeys(Keys.ENTER);
		JavascriptExecutor jse = (JavascriptExecutor) d1;
		jse.executeScript("document.getElementById('txtJourneyDate').value='27/04/2022'");

		// d1.findElement(By.xpath("//button[normalize-space()='Search for
		// Bus']")).click();
		Elements.SearcInvalidPageClick.click();

		TakesScreenshot t1 = (TakesScreenshot) d1;
		File source = t1.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\SeleniumPractice\\Selenium_Project\\ScreenShots\\SerachValidLocScreen1.jpg");
		org.openqa.selenium.io.FileHandler.copy(source, dest);

	}

	@Then("ValidserchLocation  Page")
	public void validserch_location_page() {

		System.out.println("Pass");
	}

	@Given("opnire FFox browser & url of the appln")
	public void opnire_f_fox_browser_url_of_the_appln() {

		WebDriverManager.firefoxdriver().browserVersion("98.0.2").setup();
		// WebDriver d1;
		d1 = new FirefoxDriver();
		d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d1.get("https://ksrtc.in/oprs-web/login/show.do");
		d1.manage().window().maximize();

	}

	@When("enter the validfromAndToserachLocation and click ok")
	public void enter_the_validfrom_and_toserach_location_and_click_ok() throws InterruptedException, IOException {

		PageFactory.initElements(d1, Elements.class);
		// d1.findElement(By.name("userName")).sendKeys("gopikrishnagns@gmail.com");
		Elements.UptoPaymentUserName.sendKeys("gopikrishnagns@gmail.com");
		Thread.sleep(1000);
		// d1.findElement(By.name("password")).sendKeys("Eshi@123");
		Elements.UptoPaymentPassword.sendKeys("Eshi@123");
		// d1.findElement(By.id("submitBtn")).click();
		Elements.UptoPaymentsubmitBtn.click();
		// d1.findElement(By.id("fromPlaceName")).sendKeys("MYSOR");
		Elements.UptoPaymentFromPlace.sendKeys("MYSOR");
		Thread.sleep(2000);
		// d1.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
		// Thread.sleep(1000);
		// d1.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);
		Elements.UptoPaymentFromPlace.sendKeys(Keys.ENTER);

		// Thread.sleep(2000);

		// d1.findElement(By.id("toPlaceName")).sendKeys("TIRUPATHI");
		Elements.UptoPaymentToPlace.sendKeys("TIRUPATHI");
		Thread.sleep(1000);
		// d1.findElement(By.id("toPlaceName")).sendKeys(Keys.DOWN);
		// Thread.sleep(1000);
		// d1.findElement(By.id("toPlaceName")).sendKeys(Keys.ENTER);
		Elements.UptoPaymentToPlace.sendKeys(Keys.ENTER);
		JavascriptExecutor jse = (JavascriptExecutor) d1;
		jse.executeScript("document.getElementById('txtJourneyDate').value='28/04/2022'");

		// d1.findElement(By.xpath("//button[normalize-space()='Search for
		// Bus']")).click();
		Elements.UptoPaymentSerachBusButton.click();

		Thread.sleep(1000);

		// jse.executeScript("document.getElementById('datepicker2').value='29/02/2017'");
		WebElement ele1 = d1.findElement(By.xpath("//*[@id=\"SrvcSelectBtnForward0\"]"));

		jse.executeScript("arguments[0].click();", ele1);
		// ele1.click();

		// Thread.sleep(1000);
		// d1.findElement(By.id("SrvcSelectBtnForward0")).click();

		Thread.sleep(1000);
		jse.executeScript("scroll(0,950)");
		d1.findElement(By.id("Forward48")).click();
		// d1.findElement(By.id("passengerNameForward0")).sendKeys("ABC");
		Elements.UptoPaymentPassengerName.sendKeys("ABC");
		Select s1 = new Select(d1.findElement(By.id("genderCodeIdForward0")));
		s1.selectByVisibleText("MALE");
		Thread.sleep(1000);
		// d1.findElement(By.id("passengerAgeForward0")).sendKeys("30");
		// //concessionIdsForward0
		Elements.UptoPaymentPassengerAge.sendKeys("30");

		Select s2 = new Select(d1.findElement(By.id("concessionIdsForward0")));
		s2.selectByVisibleText("GENERAL PUBLIC");
		Thread.sleep(2000);
		d1.findElement(By.id("concessionIdsForward0")).sendKeys(Keys.ENTER);
		// d1.findElement(By.id("toPlaceName")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		// d1.findElement(By.id("PgBtn")).click();
		Elements.UptoPaymentPageButton.click();

		TakesScreenshot t1 = (TakesScreenshot) d1;
		File source = t1.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\SeleniumPractice\\Selenium_Project\\ScreenShots\\UptoPaymentScreen1.jpg");
		org.openqa.selenium.io.FileHandler.copy(source, dest);
	}

	@Then("Payment  Page")
	public void payment_page() {
		System.out.println("Pass");
	}

}
