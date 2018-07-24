package com.leyou.common.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Date;

public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
	
	private static final byte[] EMPTY_ARRAY = new byte[0];
	private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	
	@SuppressWarnings("unchecked")
	public T deserialize(byte[] data) throws SerializationException {

		if (data == null || data.length == 0) {
			return null;
		}
		
		String str = new String(data, DEFAULT_CHARSET);
		try {
			JSONObject jsonObj = JSONObject.parseObject(str);
			return (T)jsonObj;
		} catch (Exception ex) {
			try{
				return (T) str;
			}catch (Exception e) {
				throw new SerializationException("Could not read JSON: " + ex.getMessage(), ex);
			}
		}
	}

	public byte[] serialize(Object source) throws SerializationException {

		if (source == null) {
			return EMPTY_ARRAY;
		}
		
		try {
			if(source instanceof String || source instanceof Character
				|| source instanceof Byte || source instanceof Short
				|| source instanceof Integer || source instanceof Long
				|| source instanceof Float || source instanceof Double
				|| source instanceof Number || source instanceof Boolean
				|| source instanceof BigDecimal || source instanceof BigInteger
				|| source instanceof Date){
				return String.valueOf(source).getBytes(DEFAULT_CHARSET);
			}
			
			return JSONObject.toJSONString(source).getBytes(DEFAULT_CHARSET);
		} catch (Exception ex) {
			throw new SerializationException("Could not write JSON: " + ex.getMessage(), ex);
		}
	}

}