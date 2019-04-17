package com.hanclouds.image.http;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.exception.HanCloudsException;
import com.hanclouds.image.util.StringUtils;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/2/27 16:30
 */
public abstract class AbstractBaseHttpRequest<T extends AbstractHttpResponse> {
    protected static final String PUT_POST_CONTENT_TYPE = "application/json";
    protected static final String SIGNATURE = "signature";
    protected static final String NONCE = "nonce";
    protected static final String TS = "ts";

    protected String url;
    protected HttpMethodEnum httpMethod;
    protected byte[] bodyContent;
    protected Map<String, String> headers;
    protected Map<String, String[]> queryParameters;
    protected Integer connectionAndReadTimeout;

    public AbstractBaseHttpRequest(String url) {
        this.url = url;
        this.headers = new HashMap<>();
        this.queryParameters = new HashMap<>();
        this.httpMethod = HttpMethodEnum.GET;
        this.connectionAndReadTimeout = 300000;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpMethodEnum getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethodEnum httpMethod) {
        this.httpMethod = httpMethod;
    }

    public byte[] getBodyContent() {
        return bodyContent;
    }

    public void setBodyContent(byte[] bodyContent) {
        this.bodyContent = bodyContent;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String[]> getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(Map<String, String[]> queryParameters) {
        this.queryParameters = queryParameters;
    }

    public Integer getConnectionAndReadTimeout() {
        return connectionAndReadTimeout;
    }

    public void setConnectionAndReadTimeout(Integer connectionAndReadTimeout) {
        this.connectionAndReadTimeout = connectionAndReadTimeout;
    }

    public void putQueryParameter(String name, String value) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(value)) {
            return;
        }
        String[] values = new String[]{value};
        this.queryParameters.put(name, values);
    }

    public void putQueryParameter(String name, String[] values) {
        if (StringUtils.isBlank(name) ||
                null == values || values.length == 0) {
            return;
        }
        this.queryParameters.put(name, values);
    }

    public void putHeader(String name, String value) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(value)) {
            return;
        }
        this.headers.put(name, value);
    }

    public void setBodyContentByObject(Object object) {
        if (!(object instanceof Number) && !(object instanceof String)) {
            //不是基本类型
            this.setBodyContent(JSON.toJSONString(object).getBytes(Charset.forName("UTF-8")));
        } else {
            //是基本类型
            this.setBodyContent(object.toString().getBytes(Charset.forName("UTF-8")));
        }
    }

    public void setBodyContentByObject(SimplePropertyPreFilter filter) {
        this.setBodyContent(JSON.toJSONString(this, filter, new SerializerFeature[0]).getBytes(Charset.forName("UTF-8")));
    }


    public T exec() throws HanCloudsException {
        //初始化参数
        this.initQueryParams();
        //请求参数验证
        this.validate();
        //初始化headers
        this.initHeaderParams();
        //生成签名
        this.signAndPut();
        //设置http参数
        HttpRequest httpRequest = setHttpRequest();
        //发送请求
        HttpResponse httpResponse = httpRequest.execute();
        return handle(httpResponse);
    }

    public abstract T handle(HttpResponse httpResponse) throws HanCloudsException;

    public abstract HttpRequest setHttpRequest();

    public abstract void initQueryParams();

    public abstract void initHeaderParams();

    public abstract void validate() throws HanCloudsClientException;

    public abstract void signAndPut() throws HanCloudsClientException;

    public abstract Class<T> getResponseClass();
}
