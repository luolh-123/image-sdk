package com.hanclouds.image.http;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/2/27 11:58
 */
public class ErrorMessage {
    private String callId;
    private String code;
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorMessage(String code, String message, String callId) {
        this.code = code;
        this.message = message;
        this.callId = callId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCallId() {
        return this.callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }
}
