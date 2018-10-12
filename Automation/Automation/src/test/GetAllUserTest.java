package test;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import pages.GetAllUser;

public class GetAllUserTest  {
	
	@Test
	public void TC_08_getUsers() throws InterruptedException, ClientProtocolException, IOException {	
		
		GetAllUser objGetllUser = new GetAllUser();
		objGetllUser.getUsers();
	
	}
	
}