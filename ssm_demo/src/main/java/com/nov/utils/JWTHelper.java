package com.nov.utils;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTHelper {

	private UUIDHelper uuidHelper = new UUIDHelper();
	
	private String SECRET = uuidHelper.getUUID();

	private void getJwtToken() {
		Date iatDate = new Date();
		// expire time
		Calendar nowTime = Calendar.getInstance();
		// 有10天有效期
		nowTime.add(Calendar.DATE, 10);
		Date expiresDate = nowTime.getTime();
		Claims claims = Jwts.claims();
		claims.put("name", "cy");
		claims.put("userId", "222");
		claims.setAudience("cy");
		claims.setIssuer("cy");
		String token = Jwts.builder().setClaims(claims).setExpiration(expiresDate)
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
	}
}
