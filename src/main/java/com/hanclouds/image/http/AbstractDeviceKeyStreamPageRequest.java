package com.hanclouds.image.http;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.util.ValidatorUtil;
import org.hibernate.validator.constraints.NotBlank;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/4/25 10:22
 */
public abstract class AbstractDeviceKeyStreamPageRequest<T extends AbstractHttpResponse> extends AbstractDeviceKeyPageRequest<T>{
    @NotBlank(message = "dataName can not null or empty")
    protected String dataName;

    public AbstractDeviceKeyStreamPageRequest(String urlStr) {
        super(urlStr);
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        ValidatorUtil.validate(this);
        try {
            dataName = URLEncoder.encode(dataName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }

        this.setUrl(this.getUrl().replace("{dataName}", this.dataName));
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
}
