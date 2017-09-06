package com.rick.utils;


import com.rick.generator.entity.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
	//private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public void encryptPassword(User user) {
		//String salt=randomNumberGenerator.nextBytes().toHex();
		String newPassword = new SimpleHash(algorithmName, user.getPassWord(),  ByteSource.Util.bytes(user.getUserName()), hashIterations).toHex();
		//String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
		user.setPassWord(newPassword);

	}
	public static void main(String[] args) {
		PasswordHelper passwordHelper = new PasswordHelper();
		User user = new User();
		user.setUserName("admin");
		user.setPassWord("admin");
		passwordHelper.encryptPassword(user);
		System.out.println(user);
	}
}
