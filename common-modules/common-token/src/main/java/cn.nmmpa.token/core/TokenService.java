package cn.nmmpa.token.core;

import cn.nmmpa.common.util.RsaUtil;
import cn.nmmpa.token.vo.TokenBody;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 14:37
 * @Version 1.0
 */
@Slf4j
public class TokenService implements ITokenService{

    /**
     * 设置token类型 (默认true为有状态走缓存 false无状态不走缓存)
     */
    private Boolean tokenType = true;

    private String publicKey;

    private String privateKey;


    @Override
    public String createToken(Map body){
        if(body == null){
            body = new HashMap(0);
        }
        //设置默认参数
        body.put("epx" ,System.currentTimeMillis());
        String token = null;
        try {
            token = RsaUtil.encrypt(JSONObject.toJSONString(body) , publicKey);
        }catch (Exception e){
            log.error("创建token失败:{}" , e);
        }
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        boolean b = true;
        try {
            RsaUtil.decrypt(token, privateKey);
        }catch (Exception e){
            b = false;
            log.error("token验证失败{}" , e);
        }
        return b;
    }

    @Override
    public Map getBody(String token) {
        Map tokenBody = null;
        try {
            String decrypt = RsaUtil.decrypt(token, privateKey);
            tokenBody = JSONObject.parseObject(decrypt , Map.class);
        }catch (Exception e){
            log.info("body数据获取失败:{}" , e);
        }
        return tokenBody;
    }

    @Override
    public TokenService setTokenType(Boolean b) {
        if(b != null){
            this.tokenType = b;
        }
        return this;
    }

    public TokenService setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public TokenService setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    public Boolean getTokenType() {
        return tokenType;
    }
}
