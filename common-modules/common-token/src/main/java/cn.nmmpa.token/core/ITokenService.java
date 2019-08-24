package cn.nmmpa.token.core;

import cn.nmmpa.token.vo.TokenBody;

import java.util.Map;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 14:37
 * @Version 1.0
 */
public interface ITokenService {

    /**
     * 创建token
     * @param body
     */
    String createToken(Map body) throws Exception;

    /**
     * 验证token
     * @param token
     */
    boolean checkToken(String token) throws Exception;

    /**
     * 获取body 参数
     * @param token
     * @return
     */
    Map getBody(String token);

    /**
     * 设置token类型 (默认true为有状态走缓存 false无状态不走缓存)
     * @param b
     */
    ITokenService setTokenType(Boolean b);
}
