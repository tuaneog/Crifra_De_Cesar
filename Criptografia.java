package cifradecesar;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Criptografia {
	
	
	private static String cifrado = "pm fvb jhu uva klwsvf fvby zlycpjlz puklwlukluasf aolu aolf hyl uva tpjyvzlycpjlz. khupls iyfhua";
	private static int numero_casas = 19;
	
	public void cifraCesar(String cifrado) {
		this.cifrado = cifrado.toLowerCase();

		}
	//Usar o número de casas para decifrar o texto e atualizar o arquivo JSON
	public String decifrar(String cifrado, int numero_casas) {
		String resultadoFinal = "";
		for(int i = 0; i < cifrado.length(); i++) {
			if(cifrado.charAt(i) <= 122 && cifrado.charAt(i) >= 97) {
				resultadoFinal += (char)(((cifrado.charAt(i) - 97 + numero_casas) % 26) + 97);
			} else {
				resultadoFinal += cifrado.charAt(i);
			}
			
		}
		
		return resultadoFinal;
		
	}
	//gerar um resumo criptográfico do texto decifrado usando o algoritmo sha1
	public String criarHash(String valor) {
		 
		String sha1 = "";

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(valor.getBytes("utf8"));
			sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sha1;
	}
	
	public static void main(String[] args) {
		Criptografia c = new Criptografia();
		String decifrar = c.decifrar(cifrado, numero_casas);
		
		String valor_checksum = c.criarHash(decifrar);
		
		System.out.println(decifrar);
		System.out.println(valor_checksum);
	}
		
}
	
	
