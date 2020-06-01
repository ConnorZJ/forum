package code.connor.forum.model;

import java.io.Serializable;

/**
 * @Description 通用响应对象
 * @Author Connor Xiong
 * @Date 2020-05-21 23:34
 */
public class RespResult implements Serializable {

    private static final long serialVersionUID = 9060426189886142545L;

    public static final String SUCCESS = "0";

    public static final String FAIL = "1";

    private String code;

    private Object data;

    private String msg;

    public RespResult(String code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public RespResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RespResult(String msg) {
        this.msg = msg;
    }

    public static RespResult success() {
        return new RespResult(SUCCESS, null, null);
    }

    public static RespResult success(Object data, String msg) {
        return new RespResult(SUCCESS, data, msg);
    }

    public static RespResult success(String msg) {
        return new RespResult(SUCCESS, msg);
    }

    public static RespResult fail() {
        return new RespResult(FAIL, null, null);
    }

    public static RespResult fail(Object data, String msg) {
        return new RespResult(FAIL, data, msg);
    }

    public static RespResult fail(String msg) {
        return new RespResult(FAIL, msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
