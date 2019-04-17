package com.hanclouds.image.resp;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.hanclouds.image.http.AbstractHttpResponse;
import com.hanclouds.image.model.DeviceImgDataDTO;

import java.util.List;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 9:55
 */
public class DeviceImageLatestDataResponse extends AbstractHttpResponse {

    private List<DeviceImgDataDTO> response;

    @Override
    public void parseBaseHttpResponse() {
        if (baseHttpResponse.getStatus() != HttpStatus.HTTP_OK) {
            return;
        }

        if (baseHttpResponse.bodyBytes() != null) {
            this.response = JSON.parseArray(baseHttpResponse.body(), DeviceImgDataDTO.class);
        }
    }

    public List<DeviceImgDataDTO> getResponse() {
        return response;
    }

    public void setResponse(List<DeviceImgDataDTO> response) {
        this.response = response;
    }
}
