package cn.nmmpa.user.config;

import cn.nmmpa.token.core.Authoriz;
import cn.nmmpa.token.core.RedisTokenCache;
import cn.nmmpa.token.core.TokenService;
import cn.nmmpa.user.vo.TokenBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 16:51
 * @Version 1.0
 */
@Configuration
public class AuthorizConfig {

    @Bean
    public Authoriz authoriz(@Autowired RedisTemplate redisTemplate ,
                             @Autowired SiteTokeConfig siteTokeConfig){
        return new Authoriz()
                .setTokenCache(new RedisTokenCache()
                        .setRedisTemplate(redisTemplate)
                        .setRefreshTime(60L * 30))
                .setTokenService(new TokenService()
                        .setPrivateKey(siteTokeConfig.getPrivateKey())
                        .setPublicKey(siteTokeConfig.getPublicKey())
                        .setPrefix(siteTokeConfig.getPrefix()));
    }
}
