package com.springboot.api.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * @author Future
 */
public class GsonUtil {
    /**
     * 将json字符串转换成对象
     *
     * @param str
     * @param clazz
     * @return
     */
    public static <T> T strToObj(String str, Class<T> clazz) {
        if (StringUtils.isBlank(str) || clazz == null) {
            return null;
        }
        return new Gson().fromJson(str, clazz);
    }

    /**
     * 获取要转换成的对象类型
     *
     * @return
     */
    public static <T> List<T> strToObjList(String str, Class<?> clazz) {
        if (StringUtils.isBlank(str) || clazz == null) {
            return null;
        }
        return new Gson().fromJson(str, new TypeToken<List<?>>() {
        }.getType());
    }

    /**
     * 将对象转换成JSON
     *
     * @param obj
     * @return
     */
    public static String objToJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return new Gson().toJson(obj);
    }

}
