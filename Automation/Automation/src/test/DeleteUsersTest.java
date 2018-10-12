package test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DeleteAllUser;
import pages.UIElementsPage;

public class DeleteUsersTest  {
	WebDriver driver=BaseTest.getDriver();
	UIElementsPage UIElementsPage = new UIElementsPage(driver, BaseTest.wait);
	
	@Test
	public void TC_09_deleteUsers() throws InterruptedException, ClientProtocolException, IOException {	
		DeleteAllUser objDeleteAllUser = new DeleteAllUser();
		objDeleteAllUser.deleteUsers();
		driver.get(BaseTest.base_url+"/users/all");
        UIElementsPage.verifyElementsAllUserPage();
	}
	
}