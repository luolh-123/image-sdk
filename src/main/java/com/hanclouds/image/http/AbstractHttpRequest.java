package com.hanclouds.image.http;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.http.Method;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.exception.HanCloudsException;
import com.hanclouds.image.util.SignUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/2/27 11:38
 */
public abstract class AbstractHttpRequest<T extends AbstractHttpResponse> extends AbstractBaseHttpRequest<T> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String serverUrl;
    private String secretKey;

    public AbstractHttpRequest(String url) {
        super(url);
    }

    @Override
    public void initQueryParams() {

        long time = System.currentTimeMillis();
        putQueryParameter(TS, String.valueOf(time));
        String nonce = SignUtils.randomNonce(16);
        putQueryParameter(NONCE, nonce);
    }

    @Override
    public void initHeaderParams() {
        if (null == httpMethod) {
            return;
        }

        //设置请求头
        if (httpMethod != HttpMethodEnum.POST && httpMethod != HttpMethodEnum.PUT) {
            this.headers.remove("Content-Type");
        } else {
            this.headers.put("Content-Type", PUT_POST_CONTENT_TYPE);
            this.headers.remove("Content-Length");
            if (bodyContent != null) {
                this.headers.put("Content-Length", String.valueOf(bodyContent.length));
            }
        }
    }

    @Override
    public void signAndPut() throws HanCloudsClientException {
        logger.debug("client:secret={}",secretKey);
        String sign = SignUtils.generateSign(secretKey, this.queryParameters, bodyContent);
        logger.debug("client:signature={}",sign);
        this.putQueryParameter(SIGNATURE, sign);
    }

    @Override
    public HttpRequest setHttpRequest() {
        HttpRequest httpRequest = new HttpRequest(getRequestUrl(this.serverUrl));
        // 设置请求方法
        switch (this.httpMethod) {
            case POST:
                httpRequest.method(Method.POST);
                break;
            case GET:
                httpRequest.method(Method.GET);
                break;
            case PUT:
                httpRequest.method(Method.PUT);
                break;
            case DELETE:
                httpRequest.method(Method.DELETE);
                break;
            default:
                httpRequest.method(Method.POST);
        }
        //连接和读取超时时间
        httpRequest.timeout(this.connectionAndReadTimeout);
        //请求头设置
        this.headers.forEach(httpRequest::header);
        //设置请求body
        httpRequest.body(bodyContent);
        return httpRequest;
    }

    private String getRequestUrl(String serverUrl) {
        // 设置url
        String requestUrl = serverUrl + this.url;

        // 设置query parameters
        if (this.queryParameters != null) {
            List<String> queryList = new ArrayList<>();
            this.queryParameters.forEach((k, v) -> {
                for (int i = 0; i < v.length; i++) {
                    try {
                        queryList.add(URLEncoder.encode(k, "utf-8") + "=" + URLEncoder.encode(v[i], "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            });
            String queryUrl = String.join("&", queryList);
            requestUrl = requestUrl + "?" + queryUrl;
        }

        return requestUrl;
    }

    @Override
    public T handle(HttpResponse httpResponse) throws HanCloudsException {
        if (httpResponse == null) {
            throw new HanCloudsException("response failed");
        } else {
            T resp;
            try {
                resp = this.getResponseClass().newInstance();
            } catch (Exception e) {
                throw new HanCloudsException(e.getMessage());
            }

            resp.setBaseHttpResponse(httpResponse);
            resp.setHttpCode(httpResponse.getStatus());
            if(httpResponse.getStatus() != HttpStatus.HTTP_OK){
                try {
                    resp.setErrorMessage(JSON.parseObject(httpResponse.body(), ErrorMessage.class));
                }catch (JSONException e){

                }

            }
            resp.parseBaseHttpResponse();
            return resp;
        }
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}