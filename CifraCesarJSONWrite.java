package cifradecesar;

import org.json.simple.JSONObject; 


import java.io.FileWriter;
import java.io.IOException;

public class CifraCesarJSONWrite {
	
	
	public static void main(String[] args) {
		
		JSONObject jsonObject = new JSONObject();
		
		FileWriter writeFile = null;
		
		jsonObject.put("numero_casas", 7);
		jsonObject.put("token", "0d1a6f456192e47eb48abb06c25ce0eee3030ed0");
		jsonObject.put("cifrado", "pm fvb jhu uva klwsvf fvby zlycpjlz puklwlukluasf aolu aolf hyl uva tpjyvzlycpjlz. khupls iyfhua");
		jsonObject.put("decifrado", "if you can not deploy your services independently then they are not microservices. daniel bryant");
		jsonObject.put("resumo_criptografico", "b0d8711b89ba5d15effe8f4663b00654dfde6de9");
		
		try {
			
			writeFile = new FileWriter("answer.json");
			writeFile.write(jsonObject.toJSONString());
			writeFile.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			
		}
		System.out.println(jsonObject);
	}
}
