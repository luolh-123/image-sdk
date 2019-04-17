package com.hanclouds.image.req;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.http.AbstractDeviceKeyStreamImgNameProcessRequest;
import com.hanclouds.image.http.HttpMethodEnum;
import com.hanclouds.image.resp.DeviceImageGetOneResponse;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:03
 */
public class DeviceImageGetOneRequest extends AbstractDeviceKeyStreamImgNameProcessRequest<DeviceImageGetOneResponse> {

    public DeviceImageGetOneRequest() {
        super("/devices/{deviceKey}/datastreams/{dataName}/images/{imgId}");
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
