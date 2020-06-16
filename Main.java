package cifradecesar;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class Main {
	
	public static void main(String[] args) throws Exception {
		

		String token = "0d1a6f456192e47eb48abb06c25ce0eee3030ed0";
        String url = "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=0d1a6f456192e47eb48abb06c25ce0eee3030ed0";
        File uploadFile = new File("C:\\Users\\tuane\\eclipse-workspace\\cifradecesar\\answer.json");

        
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        FileBody uploadFilePart = new FileBody(uploadFile);
        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("answer", uploadFilePart);
        httpPost.setEntity(reqEntity);

        HttpResponse response = httpclient.execute(httpPost);

        InputStream body = response.getEntity().getContent();

        int statusCode = response.getStatusLine().getStatusCode();

        String bodyText = inputStreamtoString(body);
        System.out.println("#######################");
        System.out.println("status code: " + statusCode);
        System.out.println("#######################");
        System.out.println(bodyText);

    }

    public static String inputStreamtoString(InputStream stream) throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = stream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        byte[] byteArray = buffer.toByteArray();

        return new String(byteArray, Charset.defaultCharset());
    }
}