package com.hanclouds.image;

import com.hanclouds.image.exception.HanCloudsException;
import com.hanclouds.image.req.DeviceStreamImageTotalRequest;
import com.hanclouds.image.resp.LongResponse;

/**
 * sdk获取设备数据流图片总数示例
 *
 * @author luolh
 * @version 1.0
 * @date 2019/3/19 10:33
 */
public class DeviceStreamImageTotalTest {

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

        /**
         * 通过用户鉴权获取设备数据流图片总数。
         * 请初始化userKey,authKey,authSecret 变量即可调用
         */
        getDeviceStreamImageTotalByUserAuth(deviceKey, dataName);

        /**
         * 通过产品鉴权获取设备数据流图片总数。
         * 请初始化productKey,queryKey,querySecret 变量即可调用
         */
        getDeviceStreamImageTotalByProductAuth(deviceKey, dataName);

        /**
         * 通过设备鉴权获取设备数据流图片总数。
         * 请初始化deviceKey,queryToken 变量即可调用
         */
        getDeviceStreamImageTotalByDeviceAuth(deviceKey, dataName);
    }

    /**
     * 通过用户鉴权获取设备数据流图片总数
     *
     * @param deviceKey
     */
    private static void getDeviceStreamImageTotalByUserAuth(String deviceKey, String dataName) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置用户鉴权参数
        client.putUserAuthParams(userKey, authKey, authSecret);

        DeviceStreamImageTotalRequest request = new DeviceStreamImageTotalRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);

        try {
            LongResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备数据流图片总数
                Long imageTotal = response.getValue();
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
     * 通过产品鉴权获取设备数据流图片总数
     *
     * @param deviceKey
     */
    private static void getDeviceStreamImageTotalByProductAuth(String deviceKey, String dataName) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置产品鉴权参数
        client.putProductAuthParams(productKey, queryKey, querySecret);

        DeviceStreamImageTotalRequest request = new DeviceStreamImageTotalRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);

        try {
            LongResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备数据流图片总数
                Long imageTotal = response.getValue();
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
     * 通过设备鉴权获取设备数据流图片总数
     *
     * @param deviceKey
     */
    private static void getDeviceStreamImageTotalByDeviceAuth(String deviceKey, String dataName) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置设备鉴权参数
        client.putDeviceAuthParams(deviceKey, queryToken);

        DeviceStreamImageTotalRequest request = new DeviceStreamImageTotalRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);

        try {
            LongResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备数据流图片总数
                Long imageTotal = response.getValue();
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
