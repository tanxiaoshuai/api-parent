package cn.nmmpa.user.config;

import cn.nmmpa.token.core.Authoriz;
import cn.nmmpa.token.core.RedisTokenCache;
import cn.nmmpa.token.core.TokenService;
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
    public Authoriz authoriz(@Autowired RedisTemplate redisTemplate){
        RedisTokenCache redisTokenCache = new RedisTokenCache();
        redisTokenCache.setRedisTemplate(redisTemplate)
                .setRefreshTime(60L);
        TokenService tokenService = new TokenService();
        tokenService.setPrivateKey("MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMhlX8029nL+rDgF/hooRj0FUSFDUh8veG/FwVVHe5HrPe2g29aE/G2cs1FWYMWu+5bnenbIG1iMb7BabGmzg9ii269TqqytX2h1LXbFi6nNoYnM8EhavPGsoJLOzJmIIbXW1ZSLWp8NciXhY0tXgVm3AT6gGZ3Ba9WEpR50KIabAgMBAAECgYEAx+KmLnG2XXm9mpwPm1O0y8Tz6bPWxBh7jzG36DJHBYOZ397lqRI5H7SAAI+iM0yY0yrNMpHjBO3/se5f2QcgaD/ERsNW9OR2J7mbVeYU+k9Ex3uXIGAgqIlOP3iGBduHRK+DeXOPhp6naEQAxI7psYiI5eY2b15oDBSDFJaj3nECQQDrumTLhhvz1FANE3aXJGJvXYbPHyB9y3RQEai/RDINs8cetD9GYccb9ke4quVYBjVbT9OO5DjwJiSqJnCX3A8vAkEA2aEi5tQ+aL+oTaXJUWkaKLQw+0Tk8kxNlZ0ggA/g8aQbonkhPDIs8GsmZiczSOqCIERz+d/t0URFcknykSFEVQJAJbPQP0UZ32vLyeudAhuNquY4k5QU7EnINq48YSsVHl/srxqBLE6jO/OuEPk0aVnE2u/vlGEoQjC3mIdBZuiJfQJAQEJTAuNSli1ZLawxGGe3QKOL/vVlwKGFGxMtIIMPwWnaewvXI2YRXN/Wk70paHNN/ucXc4WKPAszkj6BcBbpjQJBANChSgG2ZBvet7OvgfXus2jbYeyoosxCFO8kgXb2kEkfQnDDRaSiX7n16EfxSqFzdl5dRvVVT+qh4tomTr7AR1Q=")
                .setTokenType(true)
                .setPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIZV/NNvZy/qw4Bf4aKEY9BVEhQ1IfL3hvxcFVR3uR6z3toNvWhPxtnLNRVmDFrvuW53p2yBtYjG+wWmxps4PYotuvU6qsrV9odS12xYupzaGJzPBIWrzxrKCSzsyZiCG11tWUi1qfDXIl4WNLV4FZtwE+oBmdwWvVhKUedCiGmwIDAQAB");
        Authoriz authoriz = new Authoriz()
                .setTokenCache(redisTokenCache)
                .setTokenService(tokenService);
        return authoriz;
    }
}
