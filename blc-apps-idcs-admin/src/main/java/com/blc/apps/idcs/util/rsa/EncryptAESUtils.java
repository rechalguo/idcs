package com.blc.apps.idcs.util.rsa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * <p>
 * AES加密解密工具包
 * </p>
 * 
 * @author IceWee
 * @date 2012-5-18
 * @version 1.0
 */
public class EncryptAESUtils {
    /**
     * <p>
     * 生成随机密钥
     * </p>
     * 
     * @return
     * @throws Exception
     */
    public static String getSecretKey() throws Exception {
        return getSecretKey(null);
    }
    
    /**
     * <p>
     * 生成密钥
     * </p>
     * 
     * @param seed 密钥种子
     * @return
     * @throws Exception
     */
    public static String getSecretKey(String seed) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(Algorithm.ALG_AES);
        SecureRandom secureRandom;
        if (seed != null && !"".equals(seed)) {
            secureRandom = new SecureRandom(seed.getBytes());
        } else {
            secureRandom = new SecureRandom();
        }
        keyGenerator.init(Algorithm.ALG_AES_KEY_SIZE, secureRandom); 
        SecretKey secretKey = keyGenerator.generateKey(); 
        return Base64Utils.encode(secretKey.getEncoded());
    }
    
    /**
     * <p>
     * 加密
     * </p>
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(Algorithm alg, byte[] data) throws Exception {
        Key k = toKey(alg.getName(), Base64Utils.decode(alg.getKey()));
        byte[] raw = k.getEncoded(); 
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, alg.getName()); 
        Cipher cipher = Cipher.getInstance(alg.getName()); 
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);
    }
    /**
     * <p>
     * 解密
     * </p>
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(Algorithm alg, byte[] data) throws Exception {
        Key k = toKey(alg.getName(),Base64Utils.decode(alg.getKey()));
        byte[] raw = k.getEncoded(); 
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, alg.getName()); 
        Cipher cipher = Cipher.getInstance(alg.getName()); 
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);
    }
    
    
    
    /**
     * <p>
     * 文件加密
     * </p>
     * 
     * @param key
     * @param sourceFilePath
     * @param destFilePath
     * @throws Exception
     */
    public static boolean encryptFromPath(Algorithm alg, String sourceFilePath, String destFilePath) throws Exception {
        return encryptFile(alg, sourceFilePath, destFilePath);
    }
    
    /**
     * <p>
     * 文件加密
     * </p>
     * 
     * @param key
     * @param sourceFilePath
     * @param destFilePath
     * @throws Exception
     */
    public static boolean encryptFile(Algorithm alg, String sourceFilePath, String destFilePath) throws Exception {
        File sourceFile = new File(sourceFilePath);
        File destFile = new File(destFilePath); 
        if (sourceFile.exists() && sourceFile.isFile()) {
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            destFile.createNewFile();
            InputStream in = new FileInputStream(sourceFile);
            OutputStream out = new FileOutputStream(destFile);
            return encryptStream(alg, in, out);
        }
        return false;
    }
    /**
     * <p>
     * 文件加密
     * </p>
     * 
     * @param key
     * @param sourceFilePath
     * @param destFilePath
     * @throws Exception
     */
    public static boolean encryptStream(Algorithm alg, InputStream from, OutputStream to) throws Exception {
        try {    
        	Key k = toKey(alg.getName(), Base64Utils.decode(alg.getKey()));
            byte[] raw = k.getEncoded(); 
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, alg.getName()); 
            Cipher cipher = Cipher.getInstance(alg.getName()); 
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            CipherInputStream cin = new CipherInputStream(from, cipher);
            byte[] cache = new byte[Algorithm.CACHE_SIZE];
            int nRead = 0;
            while ((nRead = cin.read(cache)) != -1) {
                to.write(cache, 0, nRead);
                to.flush();
            }
            to.close();
            cin.close();
            from.close();
            return true;
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return false;
    }
    
    /**
     * <p>
     * 转换密钥
     * </p>
     * 
     * @param key
     * @return
     * @throws Exception
     */
    private static Key toKey(String alg, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, alg);
        return secretKey;
    }
    
}