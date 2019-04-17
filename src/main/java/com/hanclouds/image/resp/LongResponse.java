package com.hanclouds.image.resp;

import cn.hutool.http.HttpStatus;
import com.hanclouds.image.http.AbstractHttpResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/6/5 11:39
 */
public class LongResponse extends AbstractHttpResponse {
    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public void parseBaseHttpResponse() {
        if (baseHttpResponse.getStatus() != HttpStatus.HTTP_OK) {
            return;
        }

        if (baseHttpResponse.bodyBytes() != null) {
            this.value = Long.valueOf(baseHttpResponse.body());
        }
    }
}
