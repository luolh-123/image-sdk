package com.hanclouds.image;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.exception.HanCloudsException;
import com.hanclouds.image.http.AbstractHttpRequest;
import com.hanclouds.image.http.AbstractHttpResponse;
import com.hanclouds.image.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * 瀚云科技图片上传、下载SDK
 * @author luolh
 * @version 1.0
 * @date 2019/2/27 18:08
 */
public class HancloudsImageClient {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String serverUrl;

    private String deviceKey;

    private String productKey;
    private String serviceKey;

    private String userKey;
    private String userAuthKey;

    private String secretKey;

    public HancloudsImageClient(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public <T extends AbstractHttpResponse> CompletableFuture<T> executeAsync(AbstractHttpRequest<T> request) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return this.execute(request);
            } catch (HanCloudsException e) {
                logger.error("executeAysnc error", e);
                return null;
            }
        });
    }

    public <T extends AbstractHttpResponse> T execute(AbstractHttpRequest<T> request) throws HanCloudsException {
        if (null == request) {
            throw new HanCloudsClientException("request is null");
        }

        if (StringUtils.isBlank(serverUrl)) {
            throw new HanCloudsClientException("serverUrl is empty");
        }

        if (StringUtils.isBlank(secretKey)) {
            throw new HanCloudsClientException("no secret key for request");
        }

        boolean hadKey = false;
        if (!StringUtils.isBlank(userKey) && !StringUtils.isBlank(userAuthKey)) {
            request.putHeader("HC-USER-KEY", this.userKey);
            request.putHeader("HC-USER-AUTH-KEY", this.userAuthKey);
            hadKey = true;
        }

        if (!StringUtils.isBlank(productKey) && !StringUtils.isBlank(serviceKey)) {
            request.putHeader("HC-PRODUCT-KEY", this.productKey);
            request.putHeader("HC-PRODUCT-SERVICE-KEY", this.serviceKey);
            hadKey = true;
        }

        if (!StringUtils.isBlank(deviceKey)) {
            request.putHeader("HC-DEVICE-KEY", this.deviceKey);
            hadKey = true;
        }

        if (!hadKey) {
            throw new HanCloudsClientException("no auth keys for request");
        }

        request.setServerUrl(serverUrl);
        request.setSecretKey(secretKey);
        return request.exec();
    }

    public void putDeviceAuthParams(String deviceKey, String deviceToken) {
        if(!StringUtils.isEmpty(deviceToken)){
            this.deviceKey = deviceKey;
        }

        if(!StringUtils.isEmpty(deviceToken) && StringUtils.isEmpty(this.secretKey)){
            this.secretKey = deviceToken;
        }
    }

    public void putProductAuthParams(String productKey, String serviceKey, String secretKey) {
        if(!StringUtils.isEmpty(productKey)){
            this.productKey = productKey;
        }

        if(!StringUtils.isEmpty(serviceKey)){
            this.serviceKey = serviceKey;
        }

        if(!StringUtils.isEmpty(secretKey) && StringUtils.isEmpty(this.secretKey)){
            this.secretKey = secretKey;
        }
    }

    public void putUserAuthParams(String userKey, String userAuthKey, String secretKey) {
        if(!StringUtils.isEmpty(userKey)){
            this.userKey = userKey;
        }
        if(!StringUtils.isEmpty(userAuthKey)){
            this.userAuthKey = userAuthKey;
        }


        if(!StringUtils.isEmpty(secretKey) && StringUtils.isEmpty(this.secretKey)){
            this.secretKey = secretKey;
        }
    }
}
