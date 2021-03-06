package com.nov.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.crypto.hash.format.Base64Format;
import org.junit.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;

public class JWTHelper {

	private UUIDHelper uuidHelper = new UUIDHelper();

	private String SECRET = uuidHelper.getUUID();

	private static final String ISSUER = "user";

	// 设置7天时间
	private static final Long TTL_MILLIS = 1000l * 60 * 60 * 24 * 7;

	private String getJwtToken(String userId) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowTime = new Date();
		Date expiresDate = new Date(sdf.parse(sdf.format(nowTime)).getTime() + TTL_MILLIS);
//		Header header = Jwts.header();
//		header.put("typ", "JWT");
//		header.put("alg", "HS256");
		Claims claims = Jwts.claims();
		claims.put("name", "cy");
		claims.put("userId", "222");
		claims.setIssuer(userId);
		claims.setSubject(ISSUER);
		claims.setIssuedAt(nowTime);
		claims.setExpiration(expiresDate);
		String token = Jwts.builder().setClaims(claims).setExpiration(expiresDate)
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		return token;
	}
}
