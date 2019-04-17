package com.hanclouds.image.req;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.http.AbstractDeviceKeyStreamRequest;
import com.hanclouds.image.http.HttpMethodEnum;
import com.hanclouds.image.resp.DeviceImageTimeDataResponse;
import com.hanclouds.image.util.ValidatorUtil;
import com.hanclouds.image.valid.anno.OrderCheck;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:37
 */
public class DeviceImageTimeRequest extends AbstractDeviceKeyStreamRequest<DeviceImageTimeDataResponse> {

    @Min(value = 1, message = "limit must be greater than 0")
    @Max(value = 10, message = "limit must be less than 10")
    private Integer limit;

    @OrderCheck
    private String order;

    private Long startTime;

    private Long endTime;

    public DeviceImageTimeRequest() {
        super("/devices/{deviceKey}/datastreams/{dataName}/metadata");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DeviceImageTimeDataResponse> getResponseClass() {
        return DeviceImageTimeDataResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        ValidatorUtil.validate(this);
        this.putQueryParameter("order", order);
        this.putQueryParameter("limit", null == limit ? "1" : limit.toString());

        if (null == startTime && null == endTime) {
            startTime = 0L;
            endTime = System.currentTimeMillis();
        } else if (null == startTime) {
            startTime = 0L;
        } else if (null == endTime) {
            endTime = Long.MAX_VALUE;
        }

        this.putQueryParameter("startTime", startTime.toString());
        this.putQueryParameter("endTime", endTime.toString());
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
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

