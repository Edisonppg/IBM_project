package ibm.pracpro.utils;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtil {

	@Autowired
	private static JedisPool jedisPool;

	public static String set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.set(key, value);
		} catch (Exception e) {
			// TODO: handle exception
			return "0";
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public static String get(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.get(key);
		} catch (Exception e) {
			// TODO: handle exception
			return "0";
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}
}
