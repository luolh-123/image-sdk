package com.hanclouds.image.resp;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.hanclouds.image.http.AbstractHttpResponse;
import com.hanclouds.image.model.DeviceImgProcessDTO;

/**
 * 获取最新一张图片数据 响应
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 9:55
 */
public class DeviceImageGetLatestOneResponse extends AbstractHttpResponse {

    private DeviceImgProcessDTO response;

    @Override
    public void parseBaseHttpResponse() {
        if (baseHttpResponse.getStatus() != HttpStatus.HTTP_OK) {
            return;
        }

        if (baseHttpResponse.bodyBytes() != null) {
            this.response = JSON.parseObject(baseHttpResponse.body(), DeviceImgProcessDTO.class);
        }
    }

    public DeviceImgProcessDTO getResponse() {
        return response;
    }

    public void setResponse(DeviceImgProcessDTO response) {
        this.response = response;
    }
}
