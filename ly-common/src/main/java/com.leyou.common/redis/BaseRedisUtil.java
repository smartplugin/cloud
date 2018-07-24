package com.leyou.common.redis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 抽象Redis工具类
 *
 */
public class BaseRedisUtil {

	private RedisTemplate<String, Object> redisTemplate;
	
	public BaseRedisUtil(RedisTemplate<String, Object> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
	}
	
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	protected void set(String key, Object value) {
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		valueOperations.set(key, value);
	}
	
	/**
	 * 带失效时间以秒为单位
	 * @param key
	 * @param value
	 * @param timeout
	 */
	protected void set(String key, Object value,long timeout) {
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		valueOperations.set(key, value, timeout, TimeUnit.SECONDS );
	}
	
	protected Set<String> findKeys(String pattern){
		return redisTemplate.keys(pattern);
	}

	protected Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	protected <T> T get(String key, Class<T> clazz) {
		Object object = get(key);
		if (object == null) {
			return null;
		}
		JSONObject jsonObj = (JSONObject) object;
		return jsonObj.toJavaObject(clazz);
	}
	
	protected Object leftPop(String key) {
		return redisTemplate.opsForList().leftPop(key);
	}
	
	protected void rightPush(String key, Object value) {
		redisTemplate.opsForList().rightPush(key, value);	
	}
	
	protected <T> T leftPop(String key, Class<T> clazz) {
		Object object = leftPop(key);
		if (object == null) {
			return null;
		}
		JSONObject jsonObj = (JSONObject) object;
		return jsonObj.toJavaObject(clazz);
	}
	
	/**
	 * 存储List
	 * @param key
	 * @param values
	 * @return
	 */
	protected <T> Long setList(String key, List<Object> values) {
		return redisTemplate.opsForList().leftPushAll(key, values);
	}
	
	/**
	 * 获取List<对象>
	 * @param key
	 * @param clazz
	 * @return
	 */
	protected <T> List<Object> getList(String key, Class<T> clazz) {
		List<Object> objects = redisTemplate.opsForList().range(key, 0, -1);
		if(objects == null) {
			return null;
		}
		return objects;
	}
	
	/**
	 * 获取List<T>
	 * @param key
	 * @param clazz
	 * @return
	 */
	protected <T> List<T> getJSONList(String key, Class<T> clazz) {
		List<Object> objects = redisTemplate.opsForList().range(key, 0, -1);
		if(objects == null) {
			return null;
		}
		List<T> list = new ArrayList<T>();
		for (Object tempObj : objects) {
			JSONObject jsonObj = (JSONObject) tempObj;
			list.add(jsonObj.toJavaObject(clazz));
		}
		objects.clear();
		objects = null;
		return list;
	}
	
	/**
	 * 存储Set
	 * @param key
	 * @param values
	 * @return
	 */
	protected <T> Long addSets(String key, Object ... values) {
		return redisTemplate.opsForSet().add(key, values);
	}
	
	/**
	 * 获取Set<对象>
	 * @param key
	 * @param clazz
	 * @return
	 */
	protected <T> Set<T> getSetMembers(String key,Class<T> clazz) {
		Set<Object> members = redisTemplate.opsForSet().members(key);
		Set<T> sets = new HashSet<T>();
		for (Object tempObj : members) {
			JSONObject jsonObj = (JSONObject) tempObj;
			sets.add(jsonObj.toJavaObject(clazz));
		}
		members.clear();
		members = null;
		return sets;
	}
	
	/**获取set的size大小
	 * @param key 键
	 * @return
	 */
	protected Long getSetSize(String key) {
		return redisTemplate.opsForSet().size(key);
	}
	
	protected void delete(String key) {
		redisTemplate.delete(key);
	}
	
	protected void delete(Collection<String> keys){
		redisTemplate.delete(keys);
	}
	
	/**
	 * 为多个键分别设置他们的值
	 * 使用：Map<String,String> maps = new HashMap<String, String>();
        maps.put("multi1","ccc");
        maps.put("multi2","xxx");
        maps.put("multi3","zzz");
        template.opsForValue().multiSet(maps);
	 * @param map
	 */
	protected void multiSetObj(Map<String,Object> map) {
		redisTemplate.opsForValue().multiSet(map);
	}
	
	/***
	 * 分多个键同时取出他们的值
	 * List<String> keys = new ArrayList<String>();
        keys.add("multi1");
        keys.add("multi2");
        keys.add("multi3");
        System.out.println(template.opsForValue().multiGet(keys));
		结果：[ccc, xxx, zzz]
	 * @param keys 
	 * 
	 */
	protected List<Object> multiGetObj(List<String> keys) {
		return  redisTemplate.opsForValue().multiGet(keys);
	}
	
	/**
	 * Map操作：存储单个值至map中
	 * @param key   redisKey中的key
	 * @param key2  map所对应的key
	 * @param value map所对应的值
	 */
	protected void setMapSingle(String redisKey,String mapKey,Object value) {
		
		redisTemplate.opsForHash().put(redisKey, mapKey,value);
	}
	
	/**
	 * Map操作：存储整个map至redis
	 * @param key redis中存储的key
	 * @param map
	 */
	protected void setMapAll(String key, Map<String,Object> map) {		
		redisTemplate.opsForHash().putAll(key, map);
	}
	
	/**
	 * 获取整个HashMap
	 * @param redisKey redis中存储的key
	 * @return 整个Map
	 */
	protected Map<Object,Object> getMap(String redisKey) {
		Map<Object, Object> entries = redisTemplate.opsForHash().entries(redisKey);
		return entries;
	}
	
	/**
	 * 获取redis中hash的所有value
	 * @param redisKey
	 * @return
	 */
	protected List<Object> getMapValues(String redisKey) {
		return redisTemplate.opsForHash().values(redisKey);
	}

	/**
	 * 删除Map中的某个键值对
	 * @param redisKey
	 * @param mapKey
	 * @return 返回影响数量
	 */
	protected Long deleteMapVal(String redisKey, Object ... mapKey) {
		return redisTemplate.opsForHash().delete(redisKey , mapKey);
	}
	
	/**
	 * 确定hashkey是否存在
	 * @param redisKey redis存储的key
	 * @param mapKey 需要确定的map对象key
	 * @return
	 */
	protected boolean hasKeyRight(String redisKey, String mapKey) {
		return	redisTemplate.opsForHash().hasKey(redisKey,mapKey);
	}
	
	/**
	 * 获取Map中具体的值
	 * @param redisKey redis存储的key
	 * @param mapKey 获取的map对象key
	 * @return
	 */
	protected Object getMapVal(String redisKey, String mapKey) {
		HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
		return	opsForHash.get(redisKey,mapKey);
	}
	
	/**
	 *
	 * 从哈希中获取给定key的值
	 * @param redisKey redis存储的key
	 * @param mapKeys 需要去出的key的集合
	 * @return 值列表
	 */
	protected List<Object> multiGetHash(String redisKey, List<Object> mapKeys) {
		return  redisTemplate.opsForHash().multiGet(redisKey,mapKeys);
	}
	
	/**
	 * 获取所有map中的key
	 * @param redisKey
	 * @return
	 */
	protected Set<Object> getHashKeys(String redisKey) {
		return  redisTemplate.opsForHash().keys(redisKey);
	}
	
	/**
	 * 获取所有map中的key的数量
	 * @param redisKey
	 * @return
	 */
	protected int getHashSize(String redisKey) {
		Set<Object> keys = redisTemplate.opsForHash().keys(redisKey);
		if(keys == null){
			return 0;
		}
		return keys.size();
	}
}