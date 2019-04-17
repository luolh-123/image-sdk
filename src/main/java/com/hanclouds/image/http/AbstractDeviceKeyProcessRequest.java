package com.hanclouds.image.http;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.util.StringUtils;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/15 14:39
 */
public abstract class AbstractDeviceKeyProcessRequest<T extends AbstractHttpResponse> extends AbstractProcessRequest<T> {
    protected String deviceKey;

    public AbstractDeviceKeyProcessRequest(String url) {
        super(url);
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        if (StringUtils.isBlank(this.deviceKey)) {
            throw new HanCloudsClientException("deviceKey can not be null or empty");
        }

        this.setUrl(this.getUrl().replace("{deviceKey}", this.deviceKey));
    }
}
