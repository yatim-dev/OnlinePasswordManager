package com.project.passmanager.main.algorithms.AES;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AESEncryption {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public String encrypt(String key, String salt, String input) throws Exception {
        var secretKeySpec = generateSecretKey(key, salt);
        var cipher = Cipher.getInstance(TRANSFORMATION);

        var iv = new byte[16];
        new SecureRandom().nextBytes(iv);

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
        var encryptedBytes = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(iv) + ":" + Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String key, String salt, String encryptedText) throws Exception {
        var secretKeySpec = generateSecretKey(key, salt);

        var parts = encryptedText.split(":");
        var iv = Base64.getDecoder().decode(parts[0]);
        var encryptedBytes = Base64.getDecoder().decode(parts[1]);

        var cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
        var originalBytes = cipher.doFinal(encryptedBytes);
        return new String(originalBytes);
    }

    private SecretKeySpec generateSecretKey(String key, String salt) throws Exception {
        var factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        var spec = new PBEKeySpec((key + salt).toCharArray(), salt.getBytes(), 65536, 256);
        var tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), ALGORITHM);
    }
}
