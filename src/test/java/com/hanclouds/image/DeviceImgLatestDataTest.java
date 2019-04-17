package com.hanclouds.image;

import com.hanclouds.image.exception.HanCloudsException;
import com.hanclouds.image.model.DeviceImgDataDTO;
import com.hanclouds.image.req.DeviceImageLatestRequest;
import com.hanclouds.image.resp.DeviceImageLatestDataResponse;

import java.util.List;

/**
 * sdk获取设备最新图片元数据列表
 *
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:47
 */
public class DeviceImgLatestDataTest {

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
        //返回数据条目
        Integer limit = 1;
        //排序
        String order = "desc";

        /**
         * 通过用户鉴权获取设备最新图片元数据列表。
         * 请初始化userKey,authKey,authSecret 变量即可调用
         */
        getImageLatestMetaDataByUserAuth(deviceKey, dataName, limit, order);

        /**
         * 通过产品鉴权获取设备最新图片元数据列表。
         * 请初始化productKey,queryKey,querySecret 变量即可调用
         */
        getImageLatestMetaDataByProductAuth(deviceKey, dataName, limit, order);

        /**
         * 通过设备鉴权获取设备最新图片元数据列表。
         * 请初始化deviceKey,queryToken 变量即可调用
         */
        getImageLatestMetaDataByDeviceAuth(deviceKey, dataName, limit, order);
    }

    /**
     * 通过用户鉴权获取设备最新图片元数据列表
     *
     * @param deviceKey
     * @param dataName
     * @param limit
     * @param order
     */
    private static void getImageLatestMetaDataByUserAuth(String deviceKey, String dataName, Integer limit, String order) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置用户鉴权参数
        client.putUserAuthParams(userKey, authKey, authSecret);

        DeviceImageLatestRequest request = new DeviceImageLatestRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);
        request.setLimit(limit);
        request.setOrder(order);

        try {
            DeviceImageLatestDataResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备最新图片元数据列表
                List<DeviceImgDataDTO> deviceImgDataDTOList = response.getResponse();
                System.out.println(deviceImgDataDTOList);
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
     * 通过产品鉴权获取设备最新图片元数据列表
     *
     * @param deviceKey
     * @param dataName
     * @param limit
     * @param order
     */
    private static void getImageLatestMetaDataByProductAuth(String deviceKey, String dataName, Integer limit, String order) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置产品鉴权参数
        client.putProductAuthParams(productKey, queryKey, querySecret);

        DeviceImageLatestRequest request = new DeviceImageLatestRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);
        request.setLimit(limit);
        request.setOrder(order);

        try {
            DeviceImageLatestDataResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备最新图片元数据列表
                List<DeviceImgDataDTO> deviceImgDataDTOList = response.getResponse();
                System.out.println(deviceImgDataDTOList);
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
     * 通过设备鉴权获取设备最新图片元数据列表
     *
     * @param deviceKey
     * @param dataName
     * @param limit
     * @param order
     */
    private static void getImageLatestMetaDataByDeviceAuth(String deviceKey, String dataName, Integer limit, String order) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置设备鉴权参数
        client.putDeviceAuthParams(deviceKey, queryToken);

        DeviceImageLatestRequest request = new DeviceImageLatestRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);
        request.setLimit(limit);
        request.setOrder(order);

        try {
            DeviceImageLatestDataResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后获取设备最新图片元数据列表
                List<DeviceImgDataDTO> deviceImgDataDTOList = response.getResponse();
                System.out.println(deviceImgDataDTOList);
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
