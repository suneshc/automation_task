package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIElementsPage extends BasePage {
	
	WebDriver driver;

	By Page_header=By.className("page-header");
	By Name_header=By.xpath("//*[@id=\"registrationForm\"]/fieldset/div[1]/label");
	By Email_header=By.xpath("//*[@id=\"registrationForm\"]/fieldset/div[2]/label");
	By Password_header=By.xpath("//*[@id=\"registrationForm\"]/fieldset/div[3]/label");
	By ConfirmPassword_header=By.xpath("//*[@id=\"registrationForm\"]/fieldset/div[4]/label");
	
	By name = By.id("name");
	By email = By.id("email");
	By password = By.id("password");
	By submit = By.xpath("//button[contains(@class,'btn-primary')]");
	By confirmpassword = By.id("confirmationPassword");
	By link_alluser = By.partialLinkText("All User");
	By name_alluser=By.xpath("//*[@id=\"users\"]/thead/tr/th[1]");
	By mail_alluser=By.xpath("//*[@id=\"users\"]/thead/tr/th[2]");
	By password_alluser=By.xpath("//*[@id=\"users\"]/thead/tr/th[3]");
	By NewUser_btn=By.xpath("//*[contains(@class,'btn-default')]");
	By No_user=By.xpath("//*[@id=\"users\"]/tbody/tr/td");
	
	
	public UIElementsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	
	public void verifyElementsNewUserPage() throws InterruptedException {
		
		Assert.assertEquals("New User",readTextFromField(Page_header));
		Assert.assertEquals("Name:",readTextFromField(Name_header));
		Assert.assertEquals("Email:",readTextFromField(Email_header));
		Assert.assertEquals("Password:",readTextFromField(Password_header));
		Assert.assertEquals("Confirmation password:" ,readTextFromField(ConfirmPassword_header));
		
		Assert.assertEquals("name",readPlaceHolder(name));
		Assert.assertEquals("your@email.com",readPlaceHolder(email));
		Assert.assertEquals("min 6 characters",readPlaceHolder(password));
		Assert.assertEquals("min 6 characters",readPlaceHolder(confirmpassword));
		
		Assert.assertEquals("Submit",readTextFromField(submit));
		Assert.assertEquals("All User",readTextFromField(link_alluser));
		
		click(link_alluser);
		Thread.sleep(500);	
			
	}
	
	 
	public void verifyElementsAllUserPage() throws InterruptedException {
		
		Assert.assertEquals("All User",readTextFromField(Page_header));
		Assert.assertEquals("Name",readTextFromField(name_alluser));
		Assert.assertEquals("Email",readTextFromField(mail_alluser));
		Assert.assertEquals("Password",readTextFromField(password_alluser));
		Assert.assertEquals("New User",readTextFromField(NewUser_btn));
		Assert.assertEquals("No Users",readTextFromField(No_user));
		
		click(NewUser_btn);
		Thread.sleep(500);
		Assert.assertEquals("New User",readTextFromField(Page_header));
	} 
	      
	
	}
