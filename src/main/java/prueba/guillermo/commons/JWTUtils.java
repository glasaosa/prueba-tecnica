package prueba.guillermo.commons;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtils {

	public static final String API_JWT_SECRET = "7f2161c830771f9a4b4e423ac252e015";
	public static final String API_JWT_ISSUER = "localhost";
	public static final String API_JWT_CLAIM = "user";

	private JWTUtils() {
	}

	public static String generateJWTWithEmail(String email) {
		return Jwts.builder().setIssuedAt(new Date()).setIssuer(API_JWT_ISSUER).claim(API_JWT_CLAIM, email)
				.setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
				.signWith(SignatureAlgorithm.HS512, API_JWT_SECRET).compact();
	}
}
