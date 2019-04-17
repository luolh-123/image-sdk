package com.hanclouds.image.http;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author zhangzhan
 * @version 1.0
 * @date 2018/6/25 10:20
 */
public abstract class AbstractDeviceKeyStreamRequest<T extends AbstractHttpResponse> extends AbstractDeviceKeyRequest<T> {

    protected String dataName;

    public AbstractDeviceKeyStreamRequest(String url) {
        super(url);
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (StringUtils.isBlank(this.dataName)) {
            throw new HanCloudsClientException("dataName can not be null or empty");
        }
        try {
            dataName = URLEncoder.encode(dataName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }

        this.setUrl(this.getUrl().replace("{dataName}", this.dataName));
    }
}
