package com.hanclouds.image.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/4/25 10:48
 */
public class PageReponse<T> {
    private List<T> data;
    private int page;
    private int pageSize;
    private long total;

    public PageReponse() {
        this.data = new ArrayList<T>();
    }

    public PageReponse(List<T> data, int page, int pageSize, long total) {
        this.data = data;
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
