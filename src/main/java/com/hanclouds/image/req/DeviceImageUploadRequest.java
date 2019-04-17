package com.hanclouds.image.req;

import com.hanclouds.image.exception.HanCloudsClientException;
import com.hanclouds.image.http.AbstractDeviceKeyStreamRequest;
import com.hanclouds.image.http.HttpMethodEnum;
import com.hanclouds.image.model.HYImageTypeEnum;
import com.hanclouds.image.resp.StringResponse;
import com.hanclouds.image.util.ValidatorUtil;
import com.hanclouds.image.valid.anno.BytesCheck;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/2/27 13:39
 */
public class DeviceImageUploadRequest extends AbstractDeviceKeyStreamRequest<StringResponse> {

    /**
     * 图片类型 具体类型请参见 {@link HYImageTypeEnum}
     */
    @NotNull(message = "imageType can not be null")
    private Integer imageType;

    /**
     * 图片数据
     */
    @NotEmpty(message = "data can not be null or empty")
    @BytesCheck(max = 20 * 1024 * 1024, message = "image data's size can not be greater than 20MB")
    private byte[] data;

    public DeviceImageUploadRequest() {
        super("/devices/{deviceKey}/datastreams/{dataName}/images");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        ValidatorUtil.validate(this);
        this.putQueryParameter("imageType", imageType.toString());
        this.setBodyContent(data);
    }

    @Override
    public Class<StringResponse> getResponseClass() {
        return StringResponse.class;
    }

    public Integer getImageType() {
        return imageType;
    }

    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
