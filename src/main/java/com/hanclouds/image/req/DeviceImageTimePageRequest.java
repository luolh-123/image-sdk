package com.hanclouds.image.req;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.http.AbstractDeviceKeyStreamPageRequest;
import com.hanclouds.image.http.HttpMethodEnum;
import com.hanclouds.image.resp.DeviceImageTimeDataPageResponse;
import com.hanclouds.image.util.ValidatorUtil;

import javax.validation.constraints.Min;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:37
 */
public class DeviceImageTimePageRequest extends AbstractDeviceKeyStreamPageRequest<DeviceImageTimeDataPageResponse> {

    @Min(value = 0L, message = "startTime can not be less than 0")
    private Long startTime;
    @Min(value = 0L, message = "endTime can not be less than 0")
    private Long endTime;

    public DeviceImageTimePageRequest() {
        super("/devices/{deviceKey}/datastreams/{dataName}/metadata");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DeviceImageTimeDataPageResponse> getResponseClass() {
        return DeviceImageTimeDataPageResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        ValidatorUtil.validate(this);
        if (null == startTime && null == endTime) {
            startTime = 0L;
            endTime = System.currentTimeMillis();
        } else if (null == startTime) {
            startTime = 0L;
        } else if (null == endTime) {
            endTime = System.currentTimeMillis();
        }

        this.putQueryParameter("startTime", startTime.toString());
        this.putQueryParameter("endTime", endTime.toString());
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}

