package devkook.study.jetty;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class JerseyJettyLauncherTest {
    
	@Test
    public void 우주시간확인() throws Exception {
        //선행조건(given)
        JerseyJettyLauncher jjl = new JerseyJettyLauncher();
        System.setProperty("port", "8765");
        jjl.setPort();
        jjl.start();
        
        //기능수행(when)
        ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		String uri = "http://localhost:8765/api/SatelliteTower/ping";
		WebResource webResource = client.resource(UriBuilder.fromUri(uri).build());
		ClientResponse response = webResource.post(ClientResponse.class);
		String utime = response.getEntity(String.class);
		System.out.println("Response:" + utime);
			
        jjl.stop();

        //결과확인(then)
        assertTrue("우주시간 확인", utime.startsWith("This MHIS filed cosmology. Roger. Space-time:"));
    }
}
