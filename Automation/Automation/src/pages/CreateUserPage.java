package pages;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUserPage extends BasePage {
	WebDriver driver;

	By name = By.id("name");
	By email = By.id("email");
	By password = By.id("password");
	By submit = By.xpath("//button[contains(@class,'btn-primary')]");
	By confirmpassword = By.id("confirmationPassword");
	By link_alluser = By.partialLinkText("All User");
	By name_error=By.id("user.name.error");
	By email_error=By.id("user.email.error");
	By password_error=By.id("user.password.error");
	By confirmpassword_error=By.id("user.confirmationPassword.error");
	
	
  
	public CreateUserPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void createNewUser(XSSFRow row)  {
		writeIntoField(name, row.getCell(1).toString());
		writeIntoField(email, row.getCell(2).toString());
		writeIntoField(password, row.getCell(3).toString());
		writeIntoField(confirmpassword, row.getCell(4).toString());
		click(submit);     	
	
	}
	
	 public void verifyUserName (XSSFRow row) {
		 String expected_error=row.getCell(5).toString();
	     Assert.assertEquals(expected_error,readTextFromField(name_error));
	        
	    }
	 public void verifyEmail (XSSFRow row) {
		 String expected_error=row.getCell(6).toString();
	     Assert.assertEquals(expected_error,readTextFromField(email_error));
	      
	    }
	 public void verifyPassword (XSSFRow row) {
		 String expected_error=row.getCell(7).toString();
	     Assert.assertEquals( expected_error,readTextFromField(password_error));
	      
	    }

	 public void verifyConfirmPassword (XSSFRow row) {
		 String expected_error=row.getCell(8).toString();
	     Assert.assertEquals( expected_error,readTextFromField(confirmpassword_error));
	        
	    }

	  public void verifyCreatedUser1(XSSFRow row) throws ClientProtocolException, IOException  {
		  value=getId(0);
		  String  id_string=Integer.toString(value);
		  By name_1=By.xpath("//*[@id="+id_string+"]/td[1]");
		  Assert.assertEquals( row.getCell(1).toString(), readTextFromField(name_1));
	  }
	  
	  public void verifyCreatedUser2(XSSFRow row) throws ParseException, IOException {
		  value=getId(1);
		  String id_string=Integer.toString(value);
		  By name_1=By.xpath("//*[@id="+id_string+"]/td[1]");
		  Assert.assertEquals( row.getCell(1).toString(), readTextFromField(name_1));
	  }
	
}
