package com.springboot.api.util;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Future
 */
public class GsonUtil {
	/**
	 * 将json字符串转换成对象
	 * @param str
	 * @param clazz
	 * @return
	 */
	public static <T> T strToObj(String str , Class<T> clazz){
		if(StringUtils.isBlank(str) || clazz == null){
			return null ;
		}
		return new Gson().fromJson(str, clazz) ;
	}
	/**
	 * 将对象转换成JSON
	 * @param obj
	 * @return
	 */
	public static String  objToJson(Object obj){
		if(obj == null){
			return null;
		}
		return new Gson().toJson(obj);
	}
	

}
