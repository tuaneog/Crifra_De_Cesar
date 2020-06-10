package cifradecesar;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;


public class HttpClient_MultiPart_File_Upload {
	
	public void uploadFile() throws IOException{
		
		String urlToken = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=0d1a6f456192e47eb48abb06c25ce0eee3030ed0";
		File uploadJSON = new File("C:\\Users\tuane\\eclipse-workspace\\cifradecesar\\answer.json");
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpEntity postData = MultipartEntityBuilder.create().addBinaryBody("upfile", uploadJSON).build();
		
		HttpUriRequest postRequest = RequestBuilder.post(urlToken).setEntity(postData).build();
		
		System.out.println("Executing request " + postRequest.getRequestLine());
		
		HttpResponse response = httpclient.execute(postRequest);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed: HTTP error code: " + response.getStatusLine().getStatusCode());
		}
		
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) {
			result.append(line);
		}
		
		System.out.println("Response: \n" + result);
	}
	
}


