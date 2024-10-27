package org.example.springmvcexamples.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Code {

    // 登录错误，对应错误码400，提示用户名密码错误
    LOGIN_ERROR(Code.ERROR, "用户名密码错误"),
    // 请求错误，对应错误码400
    BAD_REQUEST(Code.ERROR, "请求错误"),
    // 未授权，对应错误码401，提示未登录
    UNAUTHORIZED(401, "未登录"),
    // token过期，对应错误码403，提示token过期，请重新登陆
    TOKEN_EXPIRED(403, "token过期，请重新登陆"),
    // 禁止访问，对应错误码403，提示无权限访问
    FORBIDDEN(403, "无权限访问");
    public static final int ERROR = 400;

    private final int number;
    private final String message;


    public int getCode() {
        return number;
    }
}