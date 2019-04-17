package com.hanclouds.image.resp;

import cn.hutool.http.HttpStatus;
import com.hanclouds.image.http.AbstractHttpResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/6/4 10:26
 */
public class IntegerResponse extends AbstractHttpResponse {

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public void parseBaseHttpResponse() {
        if (baseHttpResponse.getStatus() != HttpStatus.HTTP_OK) {
            return;
        }

        if (baseHttpResponse.bodyBytes() != null) {
            this.value = Integer.valueOf(baseHttpResponse.body());
        }
    }
}
