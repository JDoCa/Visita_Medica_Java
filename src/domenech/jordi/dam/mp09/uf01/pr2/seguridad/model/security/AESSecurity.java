package domenech.jordi.dam.mp09.uf01.pr2.seguridad.model.security;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AESSecurity {

    private static final String ENCRYPT_KEY = "clave-32-chars__________________";
    private static final String ENCRYPT_ALGORITHM = "AES";

    public String encripta(String valorOriginal) {
        String resultado = null;
        byte[] cifrado = null;
        try {
            Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_ALGORITHM);
            Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            cifrado = cipher.doFinal(valorOriginal.getBytes());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 IllegalBlockSizeException | BadPaddingException e) {
            System.err.println(e.getMessage());
        }
        if (cifrado != null) {
            resultado = Base64.getEncoder().encodeToString(cifrado);
        }
        return resultado;
    }

    public String desencripta(String cifrado) {
        String resultado = null;
        byte[] encryptedBytes = null;
        try {
            Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_ALGORITHM);
            Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            encryptedBytes = Base64.getDecoder().decode(cifrado);
            resultado = new String(cipher.doFinal(encryptedBytes));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 IllegalBlockSizeException | BadPaddingException e) {
            System.err.println(e.getMessage());
        }
        return resultado;
    }
}