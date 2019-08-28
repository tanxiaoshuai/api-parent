package cn.nmmpa.user.config;

/**
 * @Author: tan shuai
 * @Date: 2019/8/28 16:40
 * @Version 1.0
 */
public enum TabelCode {

    USER("user" , "用户")
    ;

    TabelCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }}
