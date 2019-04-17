package com.hanclouds.image.util;

import com.hanclouds.image.exception.HanCloudsClientException;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/2/27 11:02
 */
public class SignUtils {
    private static final String SIGNATURE = "signature";
    private static final String HMAC_SHA1 = "HmacSHA1";
    private static final String CHARSET_UTF8 = "utf-8";
    private static final char[] CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public SignUtils() {
    }

    public static String randomNonce(int len) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(len);

        for (int i = 0; i < len; ++i) {
            buffer.append(CHARS[random.nextInt(62)]);
        }

        return buffer.toString();
    }

    public static String signWithHmacsh1(String secret, String content) throws HanCloudsClientException {
        try {
            byte[] keyBytes = secret.getBytes(CHARSET_UTF8);
            SecretKey secretKey = new SecretKeySpec(keyBytes, HMAC_SHA1);
            Mac mac = Mac.getInstance(HMAC_SHA1);
            mac.init(secretKey);
            byte[] rawHmac = mac.doFinal(content.getBytes(CHARSET_UTF8));
            return new BASE64Encoder().encode(rawHmac);
        } catch (Exception var6) {
            throw new HanCloudsClientException("sign error");
        }
    }

    /**
     * 生成签名参数 1
     */
    public static String generateSign(String secret, Map<String, String[]> paramMap) throws HanCloudsClientException {
        return generateSign(secret, paramMap, null);
    }

    /**
     * 生成签名参数 2
     */
    public static String generateSign(String secret, Map<String, String[]> paramMap, byte[] bodyContent) throws HanCloudsClientException {

        if (null == paramMap || paramMap.size() == 0) {
            return null;
        }

        StringBuilder signStrBuilder = new StringBuilder();

        List<String> paramKeyList = new ArrayList<>(paramMap.keySet());
        Collections.sort(paramKeyList);

        paramKeyList.forEach((key) -> {
            //过滤掉签名参数
            if (SIGNATURE.equalsIgnoreCase(key)) {
                return;
            }

            String[] values = paramMap.get(key);
            if (null != values && values.length > 0) {
                for (String value : values) {
                    signStrBuilder.append("&");
                    signStrBuilder.append(key).append("=").append(value);
                }
            }
        });
        signStrBuilder.replace(0, 1, "");

        if (bodyContent != null && bodyContent.length > 0) {
            signStrBuilder.append(new String(bodyContent, Charset.forName(CHARSET_UTF8)));
        }

        return SignUtils.signWithHmacsh1(secret, signStrBuilder.toString());
    }

}
