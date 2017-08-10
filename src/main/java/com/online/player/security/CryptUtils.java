package com.online.player.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CryptUtils {

    private static final Logger logger = LoggerFactory.getLogger(CryptUtils.class);

    private static final String ALG = "AES/CBC/PKCS5Padding";

    private static final String ALG_SHORT = "AES";

    private final Cipher cipher;

    private final SecretKey secretKey = new SecretKeySpec(new byte[]{5, 6, -26, 28, -126, 89, -23, -120, -15, 21, -66, -96, 78, -48, 51, -26}, "AES");

    private final IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{82, -48, 43, -95, 97, 88, -10, -75, -46, -73, 42, -94, 102, 114, 77, -36});

    private CryptUtils() throws CryptException {
        try {
            cipher = Cipher.getInstance(ALG);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new CryptException(e);
        }
    }

    public static CryptUtils getInstance() {
        return CryptHelper.CRYPT_UTILS;
    }

    public synchronized String encode(String raw) throws CryptException {

        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            byte[] encoded = cipher.doFinal(raw.getBytes());
            return DatatypeConverter.printBase64Binary(encoded);
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | InvalidAlgorithmParameterException e) {
            throw new CryptException(e);
        }
    }

    public synchronized String decode(String encoded) throws CryptException {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] bytes = cipher.doFinal(DatatypeConverter.parseBase64Binary(encoded));
            return new String(bytes);
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | InvalidAlgorithmParameterException e) {
            throw new CryptException(e);
        }
    }

    private static class CryptHelper {

        private static final CryptUtils CRYPT_UTILS;

        static {
            try {
                CRYPT_UTILS = new CryptUtils();
            } catch (CryptException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
