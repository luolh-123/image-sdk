package com.hanclouds.image.http;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.util.ValidatorUtil;

import javax.validation.constraints.Pattern;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/15 14:39
 */
public abstract class AbstractProcessRequest<T extends AbstractHttpResponse> extends AbstractHttpRequest<T> {
    @Pattern(regexp = "[1-9]+[0-9]*,[1-9]+[0-9]*", message = "parameter format should  be something like ：100,100")
    private String forcesize;
    @Pattern(regexp = "((0\\.[1-9])|([1-9]\\d*\\.\\d)),((0\\.[1-9])|([1-9]\\d*\\.\\d))", message = "parameter format should  be something like ：0.1,0.1")
    private String rescale;

    public AbstractProcessRequest(String url) {
        super(url);
    }

    @Override
    public void validate() throws HanCloudsClientException {
        ValidatorUtil.validate(this);
        this.putQueryParameter("resize", "");
        this.putQueryParameter("forcesize", forcesize);
        this.putQueryParameter("rescale", rescale);
    }

    public String getForcesize() {
        return forcesize;
    }

    public void setForcesize(String forcesize) {
        this.forcesize = forcesize;
    }

    public String getRescale() {
        return rescale;
    }

    public void setRescale(String rescale) {
        this.rescale = rescale;
    }

}














