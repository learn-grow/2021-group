package com.geoup.springboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author: lisy
 * @version: JsonUtils , v0.1 2020年12月26日 18:38
 * @remark：JsonUtils
 */
public class JsonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    public static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 获取集合转换类
     *
     * @param collectionClass 集合
     * @param elementClass    元素类
     * @return
     */
    public static CollectionType ofClassType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
        return objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
    }

    /**
     * json映射List实体
     *
     * @param json  josn串
     * @param clazz 类
     * @param <T>   泛型
     * @return
     */
    public static <T> List<T> toListBean(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, ofClassType(ArrayList.class, clazz));
        } catch (Exception e) {
            LOGGER.error("json mapping error : {}" , e);
            throw new RuntimeException("json mapping error", e);
        }
    }

    /**
     * json映射List map 实体
     *
     * @param json josn串
     * @return
     */
    public static List<Map<String, Object>> toListMap(String json) {
        try {
            return objectMapper.readValue(json, ofClassType(ArrayList.class, Map.class));
        } catch (Exception e) {
            LOGGER.error("json mapping error : {}" , e);
            throw new RuntimeException("json mapping error", e);
        }
    }

    /**
     * list map 映射为list 实体
     *
     * @param collections 集合
     * @param clazz       实体类
     * @param <T>         泛型
     * @return
     */
    public static <T> List<T> toListBean(List<Map<String, Object>> collections, Class<T> clazz) {
        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(collections), ofClassType(ArrayList.class, clazz));
        } catch (Exception e) {
            LOGGER.error("json mapping error : {}" , e);
            throw new RuntimeException("json mapping error", e);
        }
    }

    /**
     * beannote 映射实体bean
     *
     * @param json  json字符串
     * @param clazz 实体类
     * @param <T>   泛型
     * @return
     */
    public static <T> T toBean(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            LOGGER.error("json mapping error : {}" , e);
            throw new RuntimeException("json mapping error", e);
        }
    }

    /**
     * map对象映射实体
     *
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(Map<String, Object> map, Class<T> clazz) {
        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(map), clazz);
        } catch (Exception e) {
            LOGGER.error("json mapping error : {}" , e);
            throw new RuntimeException("json mapping error", e);
        }
    }

    public static Map<String, Object> toMap(String json) {
        try {
            return objectMapper.readValue(json, Map.class);
        } catch (Exception e) {
            LOGGER.error("json mapping error : {}" , e);
            throw new RuntimeException("json mapping error", e);
        }
    }

    /**
     * 转换string
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("json mapping error : {}" , e);
            throw new RuntimeException("json mapping error", e);
        }
    }

    /**
     * map对象映射实体
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T bufferToBean(ByteBuffer buffer, Class<T> clazz) {
        try {
            return objectMapper.readValue(buffer.array(), clazz);
        } catch (Exception e) {
            LOGGER.error("json mapping error : {}" , e);
            throw new RuntimeException("json mapping error", e);
        }
    }
}
