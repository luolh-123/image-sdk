package com.hanclouds.image;

import com.hanclouds.image.exception.HanCloudsException;
import com.hanclouds.image.model.DeviceImgProcessDTO;
import com.hanclouds.image.req.DeviceImageGetOneRequest;
import com.hanclouds.image.resp.DeviceImageGetOneResponse;

/**
 * sdk获取设备指定图片数据示例
 *
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:10
 */
public class DeviceImageGetOneTest {

    //请求的图片网关服务url
    private static String serverUrl = "https://api.hanclouds.com/image/v1";

    /**
     * 为了更好的体验hanClouds image-sdk demo，请根据需要运行的Demo方法配置以下参数。
     * 如不了解鉴权参数，打开https://www.hanclouds.com/doc/2-authentication/index。
     * */
    //设备查询鉴权token
    private static String deviceKey = "";
    private static String queryToken = "";

    //产品查询鉴权密钥
    private static String productKey = "";
    private static String queryKey = "";
    private static String querySecret = "";

    //用户鉴权密钥
    private static String userKey = "";
    private static String authKey = "";
    private static String authSecret = "";

    public static void main(String[] args) {
        String deviceKey = "";
        String dataName = "";
        String imgId = "";
        //缩略参数 以下两种方式根据实际情况选择其中一种
        String forcesize = "200,200";
        String rescale = "0.1,0.1";

        /**
         * 通过用户鉴权获取设备指定图片数据。
         * 请初始化userKey,authKey,authSecret 变量即可调用
         */
        getOneImageByUserAuth(deviceKey, dataName, imgId, forcesize, rescale);

        /**
         * 通过产品鉴权获取设备指定图片数据。
         * 请初始化productKey,queryKey,querySecret 变量即可调用
         */
        getOneImageByProductAuth(deviceKey, dataName, imgId, forcesize, rescale);

        /**
         * 通过设备鉴权获取设备指定图片数据。
         * 请初始化deviceKey,queryToken 变量即可调用
         */
        getOneImageByDeviceAuth(deviceKey, dataName, imgId, forcesize, rescale);
    }

    /**
     * 通过用户鉴权获取设备指定图片数据
     *
     * @param deviceKey
     * @param dataName
     * @param imgId
     */
    private static void getOneImageByUserAuth(String deviceKey, String dataName, String imgId, String forcesize, String rescale) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置用户鉴权参数
        client.putUserAuthParams(userKey, authKey, authSecret);

        DeviceImageGetOneRequest request = new DeviceImageGetOneRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);
        request.setImgId(imgId);

        //设置缩略参数 以下两种方式根据实际情况选择其中一种
        request.setForcesize(forcesize);
        request.setRescale(rescale);

        try {
            DeviceImageGetOneResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备图片数据结果
                DeviceImgProcessDTO result = response.getResponse();
                //图片数据
                byte[] imageData = result.getData();
                //图片名
                String name = result.getName();
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
     * 通过产品鉴权获取设备指定图片数据
     *
     * @param deviceKey
     * @param dataName
     * @param imgId
     */
    private static void getOneImageByProductAuth(String deviceKey, String dataName, String imgId, String forcesize, String rescale) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置产品鉴权参数
        client.putProductAuthParams(productKey, queryKey, querySecret);

        DeviceImageGetOneRequest request = new DeviceImageGetOneRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);
        request.setImgId(imgId);

        //设置缩略参数 以下两种方式根据实际情况选择其中一种
        request.setForcesize(forcesize);
        request.setRescale(rescale);

        try {
            DeviceImageGetOneResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备图片数据结果
                DeviceImgProcessDTO result = response.getResponse();
                //图片数据
                byte[] imageData = result.getData();
                //图片名
                String name = result.getName();
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
     * 通过设备鉴权获取设备指定图片数据
     *
     * @param deviceKey
     * @param dataName
     * @param imgId
     */
    private static void getOneImageByDeviceAuth(String deviceKey, String dataName, String imgId, String forcesize, String rescale) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置设备鉴权参数
        client.putDeviceAuthParams(deviceKey, queryToken);

        DeviceImageGetOneRequest request = new DeviceImageGetOneRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);
        request.setImgId(imgId);

        //设置缩略参数 以下两种方式根据实际情况选择其中一种
        request.setForcesize(forcesize);
        request.setRescale(rescale);

        try {
            DeviceImageGetOneResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备图片数据结果
                DeviceImgProcessDTO result = response.getResponse();
                //图片数据
                byte[] imageData = result.getData();
                //图片名
                String name = result.getName();
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
