package com.geoup.springboot.configuration.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author: lisy
 * @version: RedisUtil , v0.1 2021年01月28日 15:57
 * @remark：RedisUtil
 */
@Slf4j
@Component
public class RedisUtil {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    /**
     * 指定缓存的失效时间
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.info("redis expire is error  {} ", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取key 的过期时间
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.info("redis haskey is error {}", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * del cache
     * @param key
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (null != key && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * get string cache
     * @param key
     * @return
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * set string cache
     * @param key
     * @param val
     * @return
     */
    public boolean set(String key, Object val) {
        try {
            redisTemplate.opsForValue().set(key, val);
            return true;
        } catch (Exception e) {
            log.info("redis set string cache is error {}", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * set string cache by expire
     * @param key
     * @param val
     * @param time
     * @return
     */
    private boolean set(String key, Object val, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, val, time, TimeUnit.SECONDS);
            } else {
                set(key, val);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * @param key
     * @param delta
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("incr factor must be greater than 0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     * @param key
     * @param delta
     * @return
     */
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("decr factor must be greater than 0");
        }
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    /**
     * get hash cache
     * @param key
     * @param item
     * @return
     */
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * get hash cache all
     * @param key
     * @return
     */
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * set redis hash cache
     * @param key
     * @param map
     * @return
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            log.info("redis hmset is error {}", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * redis set hash by expire time
     * @param key
     * @param map
     * @param time
     * @return
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.info("redis hmset is error {} ", e);
            e.printStackTrace();
            return false;
        }
    }

    public boolean hset(String key, String item, Object val) {
        try {
            redisTemplate.opsForHash().put(key, item, val);
            return true;
        } catch (Exception e) {
            log.info("redis hset is error {}", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * set hash cache
     * @param key
     * @param item
     * @param val
     * @param time
     * @return
     */
    public boolean hset(String key, String item, Object val, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, val);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.info("redis hset is error {}", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * del hash
     * @param key
     * @param item
     */
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断 hash  是中 是否存在 item
     * @param key
     * @param item
     * @return
     */
    public boolean hHashKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash incr 不存在则创建并递增
     * @param key
     * @param item
     * @param by
     * @return
     */
    public double hincr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hash decr 不存在则创建并递减
     * @param key
     * @param item
     * @param by
     * @return
     */
    public double hdecr(String key, String item, double by) {
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    /**
     * get key by set all
     * @param key
     * @return
     */
    public Set<Object> sGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            log.info("redis sGet is error {}", e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断 val  是否在 对应的 set中
     * @param key
     * @param val
     * @return
     */
    public boolean sHasKey(String key, Object val) {
        try {
            return redisTemplate.opsForSet().isMember(key, val);
        } catch (Exception e) {
            log.info("redis sHashkey is error {}", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * put cache to set
     * @param key
     * @param vals
     * @return
     */
    public long sSet(String key, Object... vals) {
        try {
            return redisTemplate.opsForSet().add(key, vals);
        } catch (Exception e) {
            log.info("redis sSet is error {} ", e);
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * put cache to set expire time
     * @param key
     * @param time
     * @param vals
     * @return
     */
    public long sSetAndTime(String key, long time, Object... vals) {
        try {
            long count = redisTemplate.opsForSet().add(key, vals);
            if (time > 0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            log.info("redis sSetAndTime is error {}", e);
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * get the set length
     * @param key
     * @return
     */
    public long sGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            log.info("redis get set size is error {}", e);
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * remove value
     * @param key
     * @param vals
     * @return
     */
    public long setRemove(String key, Object... vals) {
        try {
            long count = redisTemplate.opsForSet().remove(key, vals);
            return count;
        } catch (Exception e) {
            log.info("redis set remove is error {}", e);
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * get list cache
     * @param key
     * @param start 起始位置
     * @param end   结束位置 0 -1 获取全部
     * @return
     */
    public List<Object> lGet(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            log.info("redis list get is error {}", e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * get list size
     * @param key
     * @return
     */
    public long lGetListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            log.info("redis get list size is error {}", e);
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * get list cache by index
     * @param key
     * @param index 支持负数下标
     * @return
     */
    public Object lGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            log.info("redis list get by index is error {}", e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * list put to cache
     * @param key
     * @param val
     * @return
     */
    public boolean lSet(String key, Object val) {
        try {
            redisTemplate.opsForList().rightPush(key, val);
            return true;
        } catch (Exception e) {
            log.info("redis list set push is error {}", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * put cache to list expire time
     * @param key
     * @param val
     * @param time
     * @return
     */
    public boolean lSet(String key, Object val, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, val);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.info("redis lis set is error {}", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * put cache to list
     * @param key
     * @param val
     * @return
     */
    public boolean lSet(String key, List<Object> val) {
        try {
            redisTemplate.opsForList().rightPushAll(key, val);
            return true;
        } catch (Exception e) {
            log.info("redis lis set is error {} ", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * put cache to list
     * @param key
     * @param val
     * @return
     */
    public boolean lSet(String key, List<Object> val, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, val);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.info("redis lis set expire time is error {} ", e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 修改对应下标的值
     * @param key
     * @param index
     * @param val
     * @return
     */
    public boolean lUpdateIndex(String key, long index, Object val) {
        try {
            redisTemplate.opsForList().set(key , index , val);
            return true;
        }catch (Exception e){
            log.info("redis list update val by index is error {} " , e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * remove n 个值为value的
     * @param key
     * @param count
     * @param val
     * @return
     */
    public long lRemove(String key , long count , Object val) {
        try {
            long remove  = redisTemplate.opsForList().remove(key ,count , val);
            return remove;
        }catch (Exception e) {
            log.info("redis list remove val is error {}" , e);
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * bitmap set
     * @param key
     * @param offset
     * @param val
     * @return
     */
    public boolean setBit(String key , int offset , boolean val) {
        return redisTemplate.opsForValue().setBit(key, offset, val);
    }

    /**
     * 获取对应 bitmap的位
     * @param key
     * @param offset
     * @return
     */
    public boolean getBit(String key , int offset) {
        return redisTemplate.opsForValue().getBit(key , offset);
    }

}
