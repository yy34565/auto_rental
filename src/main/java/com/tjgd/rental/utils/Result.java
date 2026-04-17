package com.tjgd.rental.utils;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Result<T> {

    private Integer code;
    private String message;
    private T data;
    private Boolean success;

    public Result() {
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>().setSuccess(true)
                .setCode(ResultCode.SUCCESS).setMessage("操作成功").setData(data);
    }

    public static <T> Result<T> success() {
        return new Result<T>().setSuccess(true)
                .setCode(ResultCode.SUCCESS).setMessage("操作成功");
    }

    public static <T> Result<T> error() {
        return new Result<T>().setSuccess(false)
                .setCode(ResultCode.ERROR).setMessage("操作失败");
    }



}
