package com.hanclouds.image.req;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.http.AbstractDeviceKeyStreamProcessRequest;
import com.hanclouds.image.http.HttpMethodEnum;
import com.hanclouds.image.resp.DeviceImageGetOneResponse;

/**
 * 获取最新一张图片数据 请求
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:03
 */
public class DeviceImageGetLatestOneRequest extends AbstractDeviceKeyStreamProcessRequest<DeviceImageGetOneResponse> {

    public DeviceImageGetLatestOneRequest() {
        super("/devices/{deviceKey}/datastreams/{dataName}/latestImage");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DeviceImageGetOneResponse> getResponseClass() {
        return DeviceImageGetOneResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
    }
}
