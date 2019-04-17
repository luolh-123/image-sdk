package com.hanclouds.image.http;


import cn.hutool.http.HttpResponse;
import cn.hutool.http.Status;

import java.net.HttpURLConnection;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/2/27 11:38
 */
public abstract class AbstractHttpResponse {
    protected HttpResponse baseHttpResponse;
    protected Integer httpCode;
    protected ErrorMessage errorMessage;

    public HttpResponse getBaseHttpResponse() {
        return baseHttpResponse;
    }

    public void setBaseHttpResponse(HttpResponse baseHttpResponse) {
        this.baseHttpResponse = baseHttpResponse;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public Boolean isSuccess() {
        return this.baseHttpResponse != null && this.baseHttpResponse.getStatus() == Status.HTTP_OK ;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public abstract void parseBaseHttpResponse();
}
