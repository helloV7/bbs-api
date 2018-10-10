package com.jyt.bbs.model.vo;

public class R<D> {
    public static int CODE_SUCCESS = 200;
    public static int CODE_ERROR = 500;



    private int code;
    private String message;
    private D data;

    public int getCode() {
        return code;
    }

    public R setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public R setMessage(String message) {
        this.message = message;
        return this;
    }

    public D getData() {
        return data;
    }

    public R setData(D data) {
        this.data = data;
        return this;
    }

    public static R ok(){

        return new R().setCode(CODE_SUCCESS);
    }

    public static R error(){
        return new R().setCode(CODE_ERROR);
    }
}
