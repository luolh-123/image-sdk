package com.hanclouds.image.http;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/15 1439
 */
public abstract class AbstractDeviceKeyStreamProcessRequest<T extends AbstractHttpResponse> extends AbstractDeviceKeyProcessRequest<T> {

    protected String dataName;

    public AbstractDeviceKeyStreamProcessRequest(String url) {
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
