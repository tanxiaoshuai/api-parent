package cn.nmmpa.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by TS on 2019/8/27.
 */
@Configuration
public class SiteTokeConfig {

    @Value("${token.public.key}")
    private String publicKey;

    @Value("${token.private.key}")
    private String privateKey;

    @Value("${token.prefix}")
    private String prefix;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
