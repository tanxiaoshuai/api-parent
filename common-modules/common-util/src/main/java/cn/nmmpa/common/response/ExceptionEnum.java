package cn.nmmpa.common.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Mister Tan
 * @date 2018/9/15
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {


    SUCCESS(200 , "操作成功"),

    ERROR(500 , "操作失败"),
    ;
    int code;
    String message;

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public ExceptionEnum setValue(int code) {
        this.code = code;
        return this;
    }

    public ExceptionEnum setMessage(String message) {
        this.message = message;
        return this;
    }


}
