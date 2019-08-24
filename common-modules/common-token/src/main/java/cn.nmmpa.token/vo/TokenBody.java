package cn.nmmpa.token.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Map;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 13:56
 * @Version 1.0
 */
@Data
public class TokenBody{

    private String cacheKey;

    private Map body;

    public String bodyToString() {
        return this != null ? JSONObject.toJSONString(body) : "";
    }
}
