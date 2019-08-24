package cn.nmmpa.token.core;

import cn.nmmpa.token.exception.TokenException;
import cn.nmmpa.token.vo.TokenBody;

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
        String token = tokenService.createToken(body.getBody());
        //true走有状态token
        if(tokenService.getTokenType()){
            if(body.getCacheKey() == null || "".equals(body.getCacheKey())){
                throw new TokenException("缓存key不能为空");
            }
            tokenCache.setToken(body.getCacheKey() , token);
        }
        return token;
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
