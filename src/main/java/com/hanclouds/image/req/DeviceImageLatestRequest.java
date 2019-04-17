package com.hanclouds.image.req;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.http.AbstractDeviceKeyStreamProcessRequest;
import com.hanclouds.image.http.AbstractDeviceKeyStreamRequest;
import com.hanclouds.image.http.HttpMethodEnum;
import com.hanclouds.image.resp.DeviceImageLatestDataResponse;
import com.hanclouds.image.util.ValidatorUtil;
import com.hanclouds.image.valid.anno.OrderCheck;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:37
 */
public class DeviceImageLatestRequest extends AbstractDeviceKeyStreamRequest<DeviceImageLatestDataResponse> {

    @Min(value = 1,message = "limit must be greater than 0")
    @Max(value = 10,message = "limit must be less than 10")
    private Integer limit;

    @OrderCheck
    private String order;

    public DeviceImageLatestRequest() {
        super("/devices/{deviceKey}/datastreams/{dataName}/latestMetaData");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DeviceImageLatestDataResponse> getResponseClass() {
        return DeviceImageLatestDataResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        ValidatorUtil.validate(this);
        this.putQueryParameter("order", order);
        this.putQueryParameter("limit", null == limit ? "1" : limit.toString());
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
}

