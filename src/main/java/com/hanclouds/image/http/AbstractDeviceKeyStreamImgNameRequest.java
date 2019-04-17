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
public abstract class AbstractDeviceKeyStreamImgNameRequest<T extends AbstractHttpResponse> extends AbstractDeviceKeyStreamRequest<T> {

    protected String imageName;

    public AbstractDeviceKeyStreamImgNameRequest(String url) {
        super(url);
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (StringUtils.isBlank(this.imageName)) {
            throw new HanCloudsClientException("imageName can not null or empty");
        }
        try {
            imageName = URLEncoder.encode(imageName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }

        this.setUrl(this.getUrl().replace("{imageName}", this.imageName));
    }
}
