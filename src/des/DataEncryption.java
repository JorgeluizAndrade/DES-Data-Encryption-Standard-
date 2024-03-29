package des;

import javax.crypto.KeyGenerator;

import javax.crypto.BadPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class DataEncryption {
	public static void main(String[] args) {
		try {
			KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			SecretKey chaveDES = keygenerator.generateKey();

			Cipher cifraDes;

			cifraDes = Cipher.getInstance("DES/ECB/PKCS5Padding");

			cifraDes.init(Cipher.ENCRYPT_MODE, chaveDES);

			byte[] textPuro = "JESUS É REI".getBytes();

			System.out.println("Texto [Formato de Byte] : " + textPuro);
			System.out.println("Texto Puro : " + new String(textPuro));

			byte[] textEncriptado = cifraDes.doFinal(textPuro);

			System.out.println("Texto Encriptado : " + textEncriptado);

			cifraDes.init(Cipher.DECRYPT_MODE, chaveDES);

			byte[] textoDecriptografado = cifraDes.doFinal(textEncriptado);

			System.out.println("Texto Decriptografado : " + new String(textoDecriptografado));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
	}
}
