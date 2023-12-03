package domenech.jordi.dam.mp09.uf01.pr2.seguridad.model.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class MD5Security {

    public String encripta(String valorOriginal) {
        String resultado = null;
        try {
            MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            md.update(valorOriginal.getBytes());
            byte[] digestBytes = md.digest();
            resultado = Base64.getEncoder().encodeToString(digestBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
}