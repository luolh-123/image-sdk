## 瀚云开放平台 OpenAPI ImageSDK

**当前并未加入 Maven中央仓库，请使用Maven本地Package打包并安装使用**

如果未了解瀚云平台鉴权体系，请先查看[文档](https://www.hanclouds.com/doc/2-authentication/index).

#### Demo案例

```
        String serverUrl = "https://api.hanclouds.com/image/v1";
        //设备级鉴权码信息
        String deviceKey = "xxx";
        String queryToken = "xxx";
        //请求参数
        String dataName = "dataStreamName";
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        client.putDeviceAuthParams(deviceKey, queryToken);

        //设置请求参数
        DeviceImageGetLatestOneRequest request = new DeviceImageGetLatestOneRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);

        try {
            DeviceImageGetOneResponse response = client.execute(request);
            if (response.isSuccess()) {
                DeviceImgProcessDTO result = response.getResponse();
                //获取返回信息，并进行业务处理
            }
        } catch (HanCloudsException e) {
            e.printStackTrace();
        }
```

以上代码为获取某设备下，`dataStreamName` 数据流最新图片数据。

在ImageSDK中，每一个API都被封装成 `XXXRequest` 对象，被 `HancloudsImageClient` 执行后，将返回对应的Response，方便使用，不必再进一步自行封装了。

具体请使用对应IDE打开ImageSDK查看。package路径 `main.java.com.hanclouds.image.req`。

有任何疑问请加入QQ用户交流群：`587234791` 或者到瀚云社区直接发帖提问。<https://www.hanclouds.com/bbs>

