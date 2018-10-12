package pages;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import test.BaseTest;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;
	public int value;
	public static JsonObject jsonObject = null;
	public BasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void click(By elementLocation) {
		driver.findElement(elementLocation).click();
	}

	public void writeIntoField(By elementLocation, String text) {
		driver.findElement(elementLocation).sendKeys(text);
	}

	public String readTextFromField(By elementLocation) {
		return driver.findElement(elementLocation).getText();
	}

	public String readPlaceHolder(By elementLocation) {
		return driver.findElement(elementLocation).getAttribute("placeholder");
	}
	
	  public int getId(int i) throws ClientProtocolException, IOException {
	    	 
    	  HttpClient httpClient = HttpClientBuilder.create().build();
    	  HttpGet request=new HttpGet((BaseTest.base_url+"/user/all/json"));
    	  HttpResponse response= httpClient.execute(request);
    	  HttpEntity entity = response.getEntity();
    	  String content = EntityUtils.toString(entity);
	    
	      JsonElement je= new JsonParser().parse(content);
	      JsonArray myArray = je.getAsJsonArray();
	         
	      JsonElement jo = myArray.get(i);
	      JsonObject json = jo.getAsJsonObject();
	      JsonPrimitive tsPrimitive = json.getAsJsonPrimitive("id");
	      value=tsPrimitive.getAsInt();
		  return value;
 }
}