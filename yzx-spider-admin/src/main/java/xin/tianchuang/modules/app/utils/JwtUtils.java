package xin.tianchuang.modules.app.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import xin.tianchuang.common.constant.JwtTokenConstant;

/**
 * jwt工具类
 * 
 * @author hui.deng
 * 
 * @date 2017/9/21 22:21
 */
@ConfigurationProperties(prefix = "sys.jwt")
@Component
public class JwtUtils {
	private static Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	private String secret;
	private long expire;
	private String header;

	/**
	 * 生成jwt token
	 */
	public String generateToken(long userId) {
		Date nowDate = new Date();
		// 过期时间
		Date expireDate = new Date(nowDate.getTime() + expire * 1000);
		HashMap<String, Object> map = new HashMap<>();
		map.put("userId", userId);

		JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam("typ", JwtTokenConstant.HEADER_PARAM_TYP) //
				.setClaims(map).setSubject(userId + "") //
				.setIssuedAt(nowDate) //
				.setExpiration(expireDate) //
				.signWith(JwtTokenConstant.SIGN_ALGORITHM, secret);
		return jwtBuilder.compact();
	}

	public Claims getClaimByToken(String token) {
		try {
			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			logger.debug("validate is token error ", e);
			return null;
		}
	}

	/**
	 * token是否过期
	 * 
	 * @return true：过期
	 */
	public boolean isTokenExpired(Date expiration) {
		return expiration.before(new Date());
	}

	public String getUserNameFromToken(String token) {
		String userName;
		try {
			final Claims claims = getClaimByToken(token);
			userName = claims.getSubject();
		} catch (Exception e) {
			logger.debug("根据token获取用户名异常", e);
			userName = null;
		}
		return userName;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public long getExpire() {
		return expire;
	}

	public void setExpire(long expire) {
		this.expire = expire;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

}
