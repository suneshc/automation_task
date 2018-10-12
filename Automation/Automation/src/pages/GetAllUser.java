package pages;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import dataprovider.ConfigFileReader;


public class GetAllUser {

	static ConfigFileReader objconfigreader=new ConfigFileReader();
	public static String base_url = objconfigreader.getPropertyValue("base_url");
	
	public void getUsers() throws InterruptedException, ClientProtocolException, IOException {

    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpGet request=new HttpGet((base_url+"//user/all/json"));
    httpClient.execute(request);

  }  
  
}
