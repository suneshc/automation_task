package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import dataprovider.ExcelDataProvider;

import java.io.IOException;

import org.apache.http.ParseException;
import pages.CreateUserPage;


public class CreateUserTest  {
	
WebDriver driver=BaseTest.getDriver();
CreateUserPage objCreateUserPage = new CreateUserPage(driver, BaseTest.wait);

	@Before
	public void setupTestData() {
		ExcelDataProvider.setFileSheet("CreateNewUser");
	}
	
	@Test
	public void TC_02_emptyvalues() {

		driver.get(BaseTest.URL);
		objCreateUserPage.createNewUser(ExcelDataProvider.getRowData(2));		
		objCreateUserPage.verifyUserName(ExcelDataProvider.getRowData(2));
		objCreateUserPage.verifyEmail(ExcelDataProvider.getRowData(2));
		objCreateUserPage.verifyPassword(ExcelDataProvider.getRowData(2));
	}
	
	@Test
	public void TC_03_invalidEmail()  {

		driver.get(BaseTest.URL);
		objCreateUserPage.createNewUser(ExcelDataProvider.getRowData(3));		
		objCreateUserPage.verifyEmail(ExcelDataProvider.getRowData(3));
	}
	
	@Test
	public void TC_04_invalidPassword()  {

		driver.get(BaseTest.URL);
		objCreateUserPage.createNewUser(ExcelDataProvider.getRowData(4));		
		objCreateUserPage.verifyPassword(ExcelDataProvider.getRowData(4));
	}
	
	@Test
	public void TC_05_mismatchPassword() {

		driver.get(BaseTest.URL);
		objCreateUserPage.createNewUser(ExcelDataProvider.getRowData(5));		
		objCreateUserPage.verifyConfirmPassword(ExcelDataProvider.getRowData(5));
	}
	

	@Test
	public void TC_01_avalidUser() throws InterruptedException, ParseException, IOException {
	
		driver.get(BaseTest.URL);		
		objCreateUserPage.createNewUser(ExcelDataProvider.getRowData(1));		
		objCreateUserPage.verifyCreatedUser2(ExcelDataProvider.getRowData(1));
		
	}
	
	@Test
	public void TC_06_repeatedNameandEmail() {

		driver.get(BaseTest.URL);
		objCreateUserPage.createNewUser(ExcelDataProvider.getRowData(6));		
		objCreateUserPage.verifyUserName(ExcelDataProvider.getRowData(6));
		objCreateUserPage.verifyEmail(ExcelDataProvider.getRowData(6));
	}
	
	@Test
	public void TC_07_validUser() throws InterruptedException, ParseException, IOException {
	
		driver.get(BaseTest.URL);
		objCreateUserPage.createNewUser(ExcelDataProvider.getRowData(7));		
		objCreateUserPage.verifyCreatedUser1(ExcelDataProvider.getRowData(7));
		
	}
	

}