package org.example.springmvcexamples.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springmvcexamples.exception.Code;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    private int code;
    private String message;
    private Object data;

    private static final ResultVO EMPTY = ResultVO.builder().build();

    public static ResultVO ok() {
        // 这里明确设置数据部分为null，可根据实际需求调整
        return ResultVO.builder()
                .code(200)
                .message("success")
                .data(null)
                .build();
    }

    public static ResultVO success(Object data) {
        // 可添加对data的合法性检查，这里简单示例判断是否为null
        if (data == null) {
            throw new IllegalArgumentException("传入的数据不能为null");
        }
        return ResultVO.builder()
                .code(200)
                .message("success")
                .data(data)
                .build();
    }

    public static ResultVO error(Code code) {
        return ResultVO.builder()
                .code(code.getCode())
                .message(code.getMessage())
                .build();
    }

    public static ResultVO error(int code, String message) {
        return ResultVO.builder()
                .code(code)
                .message(message)
                .build();
    }
}