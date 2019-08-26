package cn.nmmpa.token.core;

import cn.nmmpa.token.exception.TokenException;
import cn.nmmpa.token.util.TokenAssert;
import cn.nmmpa.token.vo.BaseBody;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 15:30
 * @Version 1.0
 */
public class Authoriz<T extends BaseBody> {

    private TokenService tokenService;

    private ITokenCache tokenCache;

    /**
     * 创建令牌
     * @param body
     * @return
     */
    public String createToken(T body){
        //设置redis key
        String token = tokenService.createToken(body);
        //true走有状态token
        if(tokenService.getTokenType()){
            TokenAssert.isNotNull(body.getKey() , "缓存key不能为空");
            tokenCache.setToken(tokenCache.createRedisKey(body) , token);
        }
        return token;
    }

    public void checkToken(String token){
        BaseBody body = tokenService.getBody(token , BaseBody.class);
        TokenAssert.isNotNull(body , "token不合法");
        if(tokenService.getTokenType()){
            String redisKey = tokenCache.createRedisKey(body);
            String t = tokenCache.getToken(redisKey);
            TokenAssert.isNotNull(t , "token已过期");
            if(!t.equals(token)){
                throw new TokenException("token不合法");
            }
            //刷新时间
            tokenCache.refreshTime(redisKey);
        }else {
            if((System.currentTimeMillis() - body.getEpx()) > tokenCache.getRefreshTime()){
                throw new TokenException("token不合法");
            }
        }
    }

    /**
     * 根据token获取body内容
     * @param token
     * @return
     */
    public T getBody(String token , Class<T> tClass){
        return (T) tokenService.getBody(token , tClass);
    }


    public Authoriz setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
        return this;
    }

    public Authoriz setTokenCache(ITokenCache tokenCache) {
        this.tokenCache = tokenCache;
        return this;
    }
}
