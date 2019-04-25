package com.hanclouds.image.resp;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hanclouds.image.http.AbstractHttpResponse;
import com.hanclouds.image.model.DeviceImgDataDTO;
import com.hanclouds.image.model.PageReponse;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 9:55
 */
public class DeviceImageTimeDataPageResponse extends AbstractHttpResponse {

    private PageReponse<DeviceImgDataDTO> pageResponse;

    @Override
    public void parseBaseHttpResponse() {
        if (baseHttpResponse.getStatus() != HttpStatus.HTTP_OK) {
            return;
        }

        if (baseHttpResponse.bodyBytes() != null) {
            this.pageResponse =    JSON.parseObject(baseHttpResponse.body(),
                    new TypeReference<PageReponse<DeviceImgDataDTO>>() {
                    });
        }
    }

    public PageReponse<DeviceImgDataDTO> getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageReponse<DeviceImgDataDTO> pageResponse) {
        this.pageResponse = pageResponse;
    }
}
