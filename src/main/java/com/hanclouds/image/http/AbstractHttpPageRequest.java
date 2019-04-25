package com.hanclouds.image.http;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.util.StringUtils;
import com.hanclouds.image.util.ValidatorUtil;
import com.hanclouds.image.valid.anno.OrderCheck;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public abstract class AbstractHttpPageRequest<T extends AbstractHttpResponse> extends AbstractHttpRequest<T> {
    @OrderCheck
    protected String order;
    protected Integer page = 1;
    protected Integer pageSize = 20;

    public AbstractHttpPageRequest(String urlStr) {
        super(urlStr);
    }

    @Override
    public void validate() throws HanCloudsClientException {
        ValidatorUtil.validate(this);
        this.putQueryParameter("order", order);
        this.putQueryParameter("page", null == page ? "1" : page.toString());
        this.putQueryParameter("pageSize", null == pageSize ? "20" : pageSize.toString());
    }

    public String getOrder() {
        return order;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
