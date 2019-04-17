package com.hanclouds.image.resp;

import cn.hutool.http.HttpStatus;
import com.hanclouds.image.http.AbstractHttpResponse;

/**
 * Boolean 类型返回值
 *
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class BooleanResponse extends AbstractHttpResponse {

    private Boolean value;

    @Override
    public void parseBaseHttpResponse() {
        if (baseHttpResponse.getStatus() != HttpStatus.HTTP_OK) {
            return;
        }

        if (baseHttpResponse.bodyBytes() != null) {
            this.value = Boolean.valueOf(baseHttpResponse.body());
        }
    }

    public Boolean getValue() {
        return value;
    }
}
