package cn.nmmpa.token.core;

import cn.nmmpa.token.exception.TokenException;
import cn.nmmpa.token.util.TokenAssert;
import cn.nmmpa.token.vo.TokenBody;

import java.util.Map;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 15:30
 * @Version 1.0
 */
public class Authoriz {

    private TokenService tokenService;

    private ITokenCache tokenCache;

    /**
     * 创建令牌
     * @param body
     * @return
     */
    public String createToken(TokenBody body){
        //设置redis key
        body.getBody().put("prefix" , body.getPrefix());
        body.getBody().put("key" , body.getCacheKey());
        String token = tokenService.createToken(body.getBody());
        //true走有状态token
        if(tokenService.getTokenType()){
            if(body.getCacheKey() == null || "".equals(body.getCacheKey())){
                throw new TokenException("缓存key不能为空");
            }
            tokenCache.setToken(tokenCache.createRedisKey(body.getBody()) , token);
        }
        return token;
    }

    public void checkToken(String token){
        Map body = tokenService.getBody(token);
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
            long epx = Long.parseLong(body.get("epx").toString());
            if((System.currentTimeMillis() - epx) > tokenCache.getRefreshTime()){
                throw new TokenException("token不合法");
            }
        }
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
