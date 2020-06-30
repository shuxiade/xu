package com.nov.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.nov.entity.User;

public class PasswordHelper {
	private static final String algorithmName = "md5";
	private static final int hashIterations = 2;

	public static void encryptPassword(User user) {
		String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getSalt()),
				hashIterations).toHex();
		user.setPassword(newPassword);
	}

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("111");
		user.randomSalt();
		encryptPassword(user);
		System.out.println(user.getPassword());
		System.out.println(user.getSalt());
		System.out.println(ByteSource.Util.bytes(user.getSalt()));
//		ed0d8366a37b956d590b1f6a6d28ff3b
//		9d01bc6b32dc
//		OWQwMWJjNmIzMmRj
	}
}
