package cn.nmmpa.token.core;

import cn.nmmpa.common.util.MD5Util;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 14:10
 * @Version 1.0
 */
public class RedisTokenCache implements ITokenCache{

    /**
     * redis模板
     */
    private RedisTemplate redisTemplate;

    /**
     * 过期时间
     */
    private Long refreshTime;



    @Override
    public void setToken(String key, String token) {
        redisTemplate.opsForValue().set(key, token, refreshTime, TimeUnit.SECONDS);
    }

    @Override
    public String getToken(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void refreshTime(String key) {
        redisTemplate.expire(key, refreshTime, TimeUnit.SECONDS);
    }

    @Override
    public long getRefreshTime() {
        return this.refreshTime;
    }

    @Override
    public String createRedisKey(Map map) {
        StringBuffer redisKey = new StringBuffer();
        if(map.get("prefix") != null){
            redisKey.append(map.get("prefix").toString())
                    .append(":");
        }
        redisKey.append(MD5Util.MD5(
                        new StringBuffer(map.get("key").toString())
                                .append(map.get("epx").toString()).toString())
                );
        return redisKey.toString();
    }

    @Override
    public RedisTokenCache setRefreshTime(Long time) {
        this.refreshTime = time;
        return this;
    }

    /**
     * 设置redis模板
     * @param redisTemplate
     * @return
     */
    public RedisTokenCache setRedisTemplate(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        return this;
    }
}
