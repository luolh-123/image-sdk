package com.hanclouds.image.model;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/6 14:40
 */
public class DeviceImgDataDTO {
    private String userKey;
    private String productKey;
    /**
     * deviceKey
     */
    private String deviceKey;

    /**
     * 数据流名称
     */
    private String stream;

    /**
     * 图片名
     */
    private String imgId;

    /**
     * 图片类型 具体类型请参见 {@link HYImageTypeEnum}
     */
    private int type;

    /**
     * 图片大小
     */
    private long dataSize;

    /**
     * 上传时间
     */
    private long time;

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getDataSize() {
        return dataSize;
    }

    public void setDataSize(long dataSize) {
        this.dataSize = dataSize;
    }
}
