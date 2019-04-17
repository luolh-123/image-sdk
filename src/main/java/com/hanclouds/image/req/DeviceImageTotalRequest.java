package com.hanclouds.image.req;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.http.AbstractDeviceKeyRequest;
import com.hanclouds.image.http.HttpMethodEnum;
import com.hanclouds.image.resp.LongResponse;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:03
 */
public class DeviceImageTotalRequest extends AbstractDeviceKeyRequest<LongResponse> {

    public DeviceImageTotalRequest() {
        super("/devices/{deviceKey}/imageTotalNum");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<LongResponse> getResponseClass() {
        return LongResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
    }
}
