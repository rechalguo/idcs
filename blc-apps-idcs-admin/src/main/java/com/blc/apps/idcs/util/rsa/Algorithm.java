/**
 * 
 */
package com.blc.apps.idcs.util.rsa;

/**
 * @author guoruichao
 * @version 1.0
 * @date 2016年10月15日上午9:31:43
 */
public class Algorithm {

	public static final String ALG_AES = "AES";
	public static final int ALG_AES_KEY_SIZE = 128;
	public static final int CACHE_SIZE = 1024;
	
	private String name;
	private int keySize;
	private String key;
	public Algorithm(String name, String key, int keySize) {
		this.name = name;
		this.key = key;
		this.keySize = keySize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKeySize() {
		return keySize;
	}
	public void setKeySize(int keySize) {
		this.keySize = keySize;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
