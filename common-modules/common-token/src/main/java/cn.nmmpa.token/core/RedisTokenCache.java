package cn.nmmpa.token.core;

import cn.nmmpa.common.util.MD5Util;
import cn.nmmpa.token.vo.BaseBody;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 14:10
 * @Version 1.0
 */
public class RedisTokenCache<T> implements ITokenCache<T>{

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
    public String createRedisKey(BaseBody<T> body) {
        StringBuffer redisKey = new StringBuffer();
        if(body.getPrefix() != null){
            redisKey.append(body.getPrefix())
                    .append(":");
        }
        redisKey.append(MD5Util.MD5(
                        new StringBuffer(body.getKey())
                                .append(body.getEpx()).toString())
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
