package com.hanclouds.image;

import com.hanclouds.image.exception.HanCloudsException;
import com.hanclouds.image.model.HYImageTypeEnum;
import com.hanclouds.image.req.DeviceImageUploadRequest;
import com.hanclouds.image.resp.StringResponse;
import com.hanclouds.image.util.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * sdk图片上传示例
 *
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:11
 */
public class DeviceImageUploadTest {

    //请求的图片网关服务url
    private static String serverUrl = "https://api.hanclouds.com/image/v1";

    /**
     * 为了更好的体验hanClouds image-sdk demo，请根据需要运行的Demo方法配置以下参数。
     * 如不了解鉴权参数，打开https://www.hanclouds.com/doc/2-authentication/index。
     * */
    //设备上传鉴权token
    private static String deviceKey = "";
    private static String uploadToken = "";

    //产品上传鉴权密钥
    private static String productKey = "";
    private static String uploadKey = "";
    private static String uploadSecret = "";

    //用户鉴权密钥
    private static String userKey = "";
    private static String authKey = "";
    private static String authSecret = "";

    public static void main(String[] args) throws IOException {
        String deviceKey = "";
        String dataName = "";
        //图片类型
        Integer imageType = HYImageTypeEnum.HY_IMAGE_JPG.getType();
        //图片数据
        File file = new File("C:\\xxx\\xxx.jpg");
        byte[] imageDatas = FileUtils.toBytes(new FileInputStream(file));

        /**
         * 通过用户鉴权上传设备图片数据。
         * 请初始化userKey,authKey,authSecret 变量即可调用
         */
        uploadImageByUserAuth(deviceKey, dataName, imageType, imageDatas);

        /**
         * 通过产品uploadkey和uploadSecret鉴权上传设备图片数据。
         * 请初始化productKey,uploadKey,uploadSecret 变量即可调用
         */
        uploadImageByProductAuth(deviceKey, dataName, imageType, imageDatas);

        /**
         * 通过设备uploadToken鉴权上传设备图片数据。
         * 请初始化deviceKey,uploadToken 变量即可调用
         */
        uploadImageByDeviceAuth(deviceKey, dataName, imageType, imageDatas);
    }

    /**
     * 通过用户鉴权上传设备图片数据
     *
     * @param deviceKey
     * @param dataName
     * @param imageType
     * @param imageDatas
     */
    private static void uploadImageByUserAuth(String deviceKey, String dataName, Integer imageType, byte[] imageDatas) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置用户鉴权参数
        client.putUserAuthParams(userKey, authKey, authSecret);

        DeviceImageUploadRequest request = new DeviceImageUploadRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);
        request.setImageType(imageType);
        request.setData(imageDatas);

        try {
            StringResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备图片ID
                String imgId = response.getValue();
            } else {
                //失败是的异常信息获取
                System.out.printf("error code: %s  error msg: %s", response.getErrorMessage().getCode(), response.getErrorMessage().getMessage());
            }

            //response可以获取其它信息，具体请查看方法列表。
        } catch (HanCloudsException e) {
            e.printStackTrace();
            System.out.printf("system error: %s", e.getMessage());
        }
    }

    /**
     * 通过产品uploadkey和uploadSecret鉴权上传设备图片数据
     *
     * @param deviceKey
     * @param dataName
     * @param imageType
     * @param imageDatas
     */
    private static void uploadImageByProductAuth(String deviceKey, String dataName, Integer imageType, byte[] imageDatas) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置产品鉴权参数，此时设置产品上传密钥进行鉴权
        client.putProductAuthParams(productKey, uploadKey, uploadSecret);

        DeviceImageUploadRequest request = new DeviceImageUploadRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);
        request.setImageType(imageType);
        request.setData(imageDatas);

        try {
            StringResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备图片ID
                String imgId = response.getValue();
            } else {
                //失败是的异常信息获取
                System.out.printf("error code: %s  error msg: %s", response.getErrorMessage().getCode(), response.getErrorMessage().getMessage());
            }

            //response可以获取其它信息，具体请查看方法列表。
        } catch (HanCloudsException e) {
            e.printStackTrace();
            System.out.printf("system error: %s", e.getMessage());
        }
    }

    /**
     * 通过设备uploadToken鉴权上传设备图片数据
     *
     * @param deviceKey
     * @param dataName
     * @param imageType
     * @param imageDatas
     */
    private static void uploadImageByDeviceAuth(String deviceKey, String dataName, Integer imageType, byte[] imageDatas) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置设备鉴权参数，此时设置设备上传token进行鉴权
        client.putDeviceAuthParams(deviceKey, uploadToken);

        DeviceImageUploadRequest request = new DeviceImageUploadRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);
        request.setImageType(imageType);
        request.setData(imageDatas);

        try {
            StringResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备图片ID
                String imgId = response.getValue();
            } else {
                //失败是的异常信息获取
                System.out.printf("error code: %s  error msg: %s", response.getErrorMessage().getCode(), response.getErrorMessage().getMessage());
            }

            //response可以获取其它信息，具体请查看方法列表。
        } catch (HanCloudsException e) {
            e.printStackTrace();
            System.out.printf("system error: %s", e.getMessage());
        }
    }

}
