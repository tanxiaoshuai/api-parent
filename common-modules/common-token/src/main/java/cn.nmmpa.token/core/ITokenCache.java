package cn.nmmpa.token.core;

import cn.nmmpa.token.vo.BaseBody;

import java.util.Map;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 14:02
 * @Version 1.0
 */
public interface ITokenCache<T> {

    /**
     *
     * @param key
     * @param token
     */
   void setToken(String key , String token);

    /**
     * 获取token
     * @param key
     * @return
     */
   String getToken(String key);

    /**
     * 刷新token时间
     * @param key
     */
   void refreshTime(String key);

    /**
     * 获取刷新时间
     * @return
     */
   long getRefreshTime();

    /**
     * 创建redis key
     * @param body
     * @return
     */
   String createRedisKey(BaseBody<T> body);

    /**
     * 设置时间
     * @param time
     * @return
     */
   ITokenCache setRefreshTime(Long time);

}
