package com.hanclouds.image.resp;

import cn.hutool.http.HttpStatus;
import com.hanclouds.image.http.AbstractHttpResponse;

/**
 * String 类型返回值
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class StringResponse extends AbstractHttpResponse {

    private String value;

    @Override
    public void parseBaseHttpResponse() {
        if (baseHttpResponse.getStatus() != HttpStatus.HTTP_OK) {
            return;
        }

        if (baseHttpResponse.bodyBytes() != null) {
            this.value = baseHttpResponse.body();
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
