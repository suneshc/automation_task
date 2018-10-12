package pages;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;

import dataprovider.ConfigFileReader;

public class DeleteAllUser {
	
	static ConfigFileReader objconfigreader=new ConfigFileReader();
	public static String base_url = objconfigreader.getPropertyValue("base_url");
	
	public void deleteUsers() throws InterruptedException, ClientProtocolException, IOException {

    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpDelete request=new HttpDelete(base_url+"/user/all");
    httpClient.execute(request);
   }
}
