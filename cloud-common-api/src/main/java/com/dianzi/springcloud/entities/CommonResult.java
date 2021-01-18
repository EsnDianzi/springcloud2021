package com.dianzi.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/18
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T Data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
