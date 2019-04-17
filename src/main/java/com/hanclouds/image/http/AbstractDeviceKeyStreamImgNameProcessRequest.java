package com.hanclouds.image.http;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/15 14:39
 */
public abstract class AbstractDeviceKeyStreamImgNameProcessRequest<T extends AbstractHttpResponse> extends AbstractDeviceKeyStreamProcessRequest<T> {

    protected String imgId;

    public AbstractDeviceKeyStreamImgNameProcessRequest(String url) {
        super(url);
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (StringUtils.isBlank(this.imgId)) {
            throw new HanCloudsClientException("imgId can not be null or empty");
        }
        try {
            imgId = URLEncoder.encode(imgId, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }

        this.setUrl(this.getUrl().replace("{imgId}", this.imgId));
    }
}
