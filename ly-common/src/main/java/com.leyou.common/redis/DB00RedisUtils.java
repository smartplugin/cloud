package com.leyou.common.redis;

import com.leyou.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author chendong
 * @date 2018-07-18
 * @description 活动详情缓存
 */
@Component
public class DB00RedisUtils {

    private static BaseRedisUtil baseRedisUtil;

    private static Logger logger = LoggerFactory.getLogger(DB00RedisUtils.class);

    @Autowired
    @Qualifier(value = "db01RedisTemplate")
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) throws Exception {
        logger.debug("初始化DB00RedisUtils的baseRedisUtils");
        if (redisTemplate == null) {
            throw new Exception("===没有注入redisTemplate===");
        }
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) connectionFactory;
        if (jedisConnectionFactory.getDatabase() < 0) {
            throw new Exception("===检查redis配置, 使用redis.db0缓存活动相关信息===");
        }
        baseRedisUtil = new BaseRedisUtil(redisTemplate);
    }

    public static Object getString(String key) {
        return baseRedisUtil.get(Constants.DB00_KEY + key);
    }


    public static void setString(String key,String value) {
        baseRedisUtil.set(Constants.DB00_KEY + key, value);
    }


}
