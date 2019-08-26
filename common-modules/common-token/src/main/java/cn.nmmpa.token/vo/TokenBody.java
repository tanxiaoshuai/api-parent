package cn.nmmpa.token.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 13:56
 * @Version 1.0
 */
@Data
public class TokenBody{

    private String cacheKey;

    private String prefix;

    private Map body;

    public TokenBody() {
    }

    public TokenBody(String cacheKey, String prefix) {
        this.cacheKey = cacheKey;
        this.prefix = prefix;
    }

    public String bodyToString() {
        return this != null ? JSONObject.toJSONString(body) : "";
    }

    public Map getBody() {
        return this.body = body == null ? new HashMap(0) : body;
    }
}
