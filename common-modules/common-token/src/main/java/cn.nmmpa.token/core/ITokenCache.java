package cn.nmmpa.token.core;

import cn.nmmpa.token.vo.BaseBody;

import java.util.Map;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 14:02
 * @Version 1.0
 */
public interface ITokenCache<T extends BaseBody> {

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
     */
   long getRefreshTime();

    /**
     * 创建redis key
     * @param map
     * @return
     */
   String createRedisKey(T map);

    /**
     * 设置时间
     * @param time
     */
   ITokenCache setRefreshTime(Long time);

}
