package com.hanclouds.image.http;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.util.ValidatorUtil;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/4/25 10:23
 */
public abstract class AbstractDeviceKeyPageRequest<T extends AbstractHttpResponse> extends AbstractHttpPageRequest<T> {
    @NotBlank(message = "deviceKey can not null or empty")
    protected String deviceKey;

    public AbstractDeviceKeyPageRequest(String urlStr) {
        super(urlStr);
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        ValidatorUtil.validate(this);
        this.setUrl(this.getUrl().replace("{deviceKey}", this.deviceKey));
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }
}
