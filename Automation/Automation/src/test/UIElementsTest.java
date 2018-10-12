package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.UIElementsPage;;


public class UIElementsTest  {
	
WebDriver driver=BaseTest.getDriver();
UIElementsPage UIElementsPage = new UIElementsPage(driver, BaseTest.wait);
	
   @Test
	public void TC_10_UIverifyNewUserPage() throws InterruptedException {	
		UIElementsPage.verifyElementsNewUserPage();
		
	}

	@Test
	public void TC_11_UIverifyAllUserPage() throws InterruptedException {
	driver.get(BaseTest.base_url+"/users/all");
		UIElementsPage.verifyElementsAllUserPage();
		
	}
	
}