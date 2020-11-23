package ibm.pracpro.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisUtil {

	@Autowired
	private JedisPool jedisPool;

	public String set(String key, String value) {
		Jedis jedis = null;
		String result=null;
		System.out.println(jedisPool);
		try {
			jedis = jedisPool.getResource();
			result= jedis.set(key, value);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "0";
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return result;
	}

	public String get(String key) {
		Jedis jedis = null;
		String result=null;
//		System.out.println(jedisPool);
		try {
			jedis = jedisPool.getResource();
			result= jedis.get(key);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result= "0";
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return result;
	}
}
