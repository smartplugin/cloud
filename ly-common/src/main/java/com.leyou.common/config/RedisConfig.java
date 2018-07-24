package com.leyou.common.config;

import com.leyou.common.fastjson.FastJsonRedisSerializer;
import com.leyou.common.redis.DB00RedisUtils;
import com.leyou.common.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;

import javax.xml.bind.PrintConversionEvent;


/**
 * @author chendong
 * @date 2018-07-12
 * @description
 */
@Component
@PropertySource(value ={"classpath:config/redis.properties"})
@ConfigurationProperties(prefix = "ly.jedis")
public class RedisConfig {

    private final static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    /**
     * =========================================Redis配置参数================================================
     */

    private String host;
    private Integer port;
    private String password;
    private Integer timeout;
    private Integer maxTotal;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxWait;
    private Boolean testOnBorrow;
    private Integer database_00;
    private Integer database_01;
    private Integer database_02;
    private Integer database_03;
    private Integer database_04;
    private Integer database_05;
    private Integer database_06;
    private Integer database_07;
    private Integer database_08;
    private Integer database_09;
    private Integer database_10;
    private Integer database_11;
    private Integer database_12;
    private Integer database_13;
    private Integer database_14;
    private Integer database_15;

    public Integer getDatabase_00() {
        return database_00;
    }

    public void setDatabase_00(Integer database_00) {
        this.database_00 = database_00;
    }

    public Integer getDatabase_01() {
        return database_01;
    }

    public void setDatabase_01(Integer database_01) {
        this.database_01 = database_01;
    }

    public Integer getDatabase_02() {
        return database_02;
    }

    public void setDatabase_02(Integer database_02) {
        this.database_02 = database_02;
    }

    public Integer getDatabase_03() {
        return database_03;
    }

    public void setDatabase_03(Integer database_03) {
        this.database_03 = database_03;
    }

    public Integer getDatabase_04() {
        return database_04;
    }

    public void setDatabase_04(Integer database_04) {
        this.database_04 = database_04;
    }

    public Integer getDatabase_05() {
        return database_05;
    }

    public void setDatabase_05(Integer database_05) {
        this.database_05 = database_05;
    }

    public Integer getDatabase_06() {
        return database_06;
    }

    public void setDatabase_06(Integer database_06) {
        this.database_06 = database_06;
    }

    public Integer getDatabase_07() {
        return database_07;
    }

    public void setDatabase_07(Integer database_07) {
        this.database_07 = database_07;
    }

    public Integer getDatabase_08() {
        return database_08;
    }

    public void setDatabase_08(Integer database_08) {
        this.database_08 = database_08;
    }

    public Integer getDatabase_09() {
        return database_09;
    }

    public void setDatabase_09(Integer database_09) {
        this.database_09 = database_09;
    }

    public Integer getDatabase_10() {
        return database_10;
    }

    public void setDatabase_10(Integer database_10) {
        this.database_10 = database_10;
    }

    public Integer getDatabase_11() {
        return database_11;
    }

    public void setDatabase_11(Integer database_11) {
        this.database_11 = database_11;
    }

    public Integer getDatabase_12() {
        return database_12;
    }

    public void setDatabase_12(Integer database_12) {
        this.database_12 = database_12;
    }

    public Integer getDatabase_13() {
        return database_13;
    }

    public void setDatabase_13(Integer database_13) {
        this.database_13 = database_13;
    }

    public Integer getDatabase_14() {
        return database_14;
    }

    public void setDatabase_14(Integer database_14) {
        this.database_14 = database_14;
    }

    public Integer getDatabase_15() {
        return database_15;
    }

    public void setDatabase_15(Integer database_15) {
        this.database_15 = database_15;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }


    /**
     * =========================================jedis连接池配置================================================
     */
    //单例模式
    private static JedisPoolConfig jedisPoolConfig;

    private JedisPoolConfig jedisPoolConfig() {
        if (jedisPoolConfig != null) {
            return jedisPoolConfig;
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        this.jedisPoolConfig = jedisPoolConfig;
        return jedisPoolConfig;
    }

    /**
     * =========================================jedis连接工厂类配置================================================
     */

    public JedisConnectionFactory jedisConnectionFactory(Integer dataBase) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setPassword(password);
        jedisConnectionFactory.setDatabase(dataBase);
        jedisConnectionFactory.setTimeout(timeout);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
        return jedisConnectionFactory;
    }


    /**
     * 设置模板的序列化规则
     *
     * @param redisTemplate
     * @return
     */
    private RedisTemplate setProperties(RedisTemplate redisTemplate) {
        //字符串序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //使用fastjson序列化
        FastJsonRedisSerializer<Object> objectFastJsonRedisSerializer = new FastJsonRedisSerializer<>();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(objectFastJsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(objectFastJsonRedisSerializer);
        return redisTemplate;
    }

    /**
     * ======================================RedisTemplate模板初始化 db00-db15===================================================
     */
    @Bean("db00RedisTemplate")
    public RedisTemplate db00RedisTemplate() {
        RedisTemplate DBXXRedisTemplate = new RedisTemplate();
        DBXXRedisTemplate.setConnectionFactory(jedisConnectionFactory(database_00));
        RedisTemplate redisTemplate = setProperties(DBXXRedisTemplate);
        logger.debug("初始化redis{}模板：{}", "00", DBXXRedisTemplate);
        return redisTemplate;
    }

    @Bean("db01RedisTemplate")
    public RedisTemplate db01RedisTemplate() {
        RedisTemplate db01RedisTemplate = new RedisTemplate();
        db01RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_01));
        RedisTemplate redisTemplate = setProperties(db01RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "01", db01RedisTemplate);
        return redisTemplate;
    }

    @Bean("db02RedisTemplate")
    public RedisTemplate db02RedisTemplate() {
        RedisTemplate db02RedisTemplate = new RedisTemplate();
        db02RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_02));
        RedisTemplate redisTemplate = setProperties(db02RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "02", db02RedisTemplate);
        return redisTemplate;
    }

    @Bean("db03RedisTemplate")
    public RedisTemplate db03RedisTemplate() {
        RedisTemplate db03RedisTemplate = new RedisTemplate();
        db03RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_03));
        RedisTemplate redisTemplate = setProperties(db03RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "03", db03RedisTemplate);
        return redisTemplate;
    }



    @Bean("db04RedisTemplate")
    public RedisTemplate db04RedisTemplate() {
        RedisTemplate db04RedisTemplate = new RedisTemplate();
        db04RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_04));
        RedisTemplate redisTemplate = setProperties(db04RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "04", db04RedisTemplate);
        return redisTemplate;
    }

    @Bean("db05RedisTemplate")
    public RedisTemplate db05RedisTemplate() {
        RedisTemplate db05RedisTemplate = new RedisTemplate();
        db05RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_05));
        RedisTemplate redisTemplate = setProperties(db05RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "05", db05RedisTemplate);
        return redisTemplate;
    }

    @Bean("db06RedisTemplate")
    public RedisTemplate db06RedisTemplate() {
        RedisTemplate db06RedisTemplate = new RedisTemplate();
        db06RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_06));
        RedisTemplate redisTemplate = setProperties(db06RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "06", db06RedisTemplate);
        return redisTemplate;
    }

    @Bean("db07RedisTemplate")
    public RedisTemplate db07RedisTemplate() {
        RedisTemplate db07RedisTemplate = new RedisTemplate();
        db07RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_07));
        RedisTemplate redisTemplate = setProperties(db07RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "07", db07RedisTemplate);
        return redisTemplate;
    }

    @Bean("db08RedisTemplate")
    public RedisTemplate db08RedisTemplate() {
        RedisTemplate db08RedisTemplate = new RedisTemplate();
        db08RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_08));
        RedisTemplate redisTemplate = setProperties(db08RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "08", db08RedisTemplate);
        return redisTemplate;
    }

    @Bean("db09RedisTemplate")
    public RedisTemplate db09RedisTemplate() {
        RedisTemplate db09RedisTemplate = new RedisTemplate();
        db09RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_09));
        RedisTemplate redisTemplate = setProperties(db09RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "09", db09RedisTemplate);
        return redisTemplate;
    }

    @Bean("db10RedisTemplate")
    public RedisTemplate db10RedisTemplate() {
        RedisTemplate db10RedisTemplate = new RedisTemplate();
        db10RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_10));
        RedisTemplate redisTemplate = setProperties(db10RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "10", db10RedisTemplate);
        return redisTemplate;
    }

    @Bean("db11RedisTemplate")
    public RedisTemplate db11RedisTemplate() {
        RedisTemplate db11RedisTemplate = new RedisTemplate();
        db11RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_11));
        RedisTemplate redisTemplate = setProperties(db11RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "11", db11RedisTemplate);
        return redisTemplate;
    }

    @Bean("db12RedisTemplate")
    public RedisTemplate db12RedisTemplate() {
        RedisTemplate db12RedisTemplate = new RedisTemplate();
        db12RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_12));
        RedisTemplate redisTemplate = setProperties(db12RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "12", db12RedisTemplate);
        return redisTemplate;
    }

    @Bean("db13RedisTemplate")
    public RedisTemplate db13RedisTemplate() {
        RedisTemplate db13RedisTemplate = new RedisTemplate();
        db13RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_13));
        RedisTemplate redisTemplate = setProperties(db13RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "13", db13RedisTemplate);
        return redisTemplate;
    }

    @Bean("db14RedisTemplate")
    public RedisTemplate db14RedisTemplate() {
        RedisTemplate db14RedisTemplate = new RedisTemplate();
        db14RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_14));
        RedisTemplate redisTemplate = setProperties(db14RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "14", db14RedisTemplate);
        return redisTemplate;
    }

    @Bean("db15RedisTemplate")
    public RedisTemplate db15RedisTemplate() {
        RedisTemplate db15RedisTemplate = new RedisTemplate();
        db15RedisTemplate.setConnectionFactory(jedisConnectionFactory(database_15));
        RedisTemplate redisTemplate = setProperties(db15RedisTemplate);
        logger.debug("初始化redis{}模板：{}", "15", db15RedisTemplate);
        return redisTemplate;
    }




}
