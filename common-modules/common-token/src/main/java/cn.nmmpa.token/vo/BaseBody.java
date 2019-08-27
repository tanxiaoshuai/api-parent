package cn.nmmpa.token.vo;


/**
 * @author tan
 * Created by TS on 2019/8/26.
 */
public class BaseBody<T> {

    private String key;

    private String prefix = "TOKEN";

    private long epx = System.currentTimeMillis();

    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public long getEpx() {
        return epx;
    }

    public void setEpx(long epx) {
        this.epx = epx;
    }
}
