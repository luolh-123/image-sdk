package com.hanclouds.image.http;


import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.util.StringUtils;

/**
 * @author zhangzhan
 * @version 1.0
 * @date 2018/6/25 10:20
 */
public abstract class AbstractDeviceKeyRequest<T extends AbstractHttpResponse> extends AbstractHttpRequest<T> {

    protected String deviceKey;

    public AbstractDeviceKeyRequest(String url) {
        super(url);
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    @Override
    public void validate()  throws HanCloudsClientException {
        if (StringUtils.isBlank(this.deviceKey)) {
            throw new HanCloudsClientException("deviceKey can not be null or empty");
        }

        this.setUrl(this.getUrl().replace("{deviceKey}", this.deviceKey));
    }
}
