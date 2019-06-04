package io.zhanghao.spring.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghao
 * @date 2019/06/02
 */
@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 1000750575023608035L;
    private Integer code;
    private String msg;
    private T data;
}
