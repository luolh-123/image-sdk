package com.hanclouds.image.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/2/22 11:45
 */
public enum HYImageTypeEnum {
    /**
     * invalid type
     */
    HY_IMAGE_INVALID(0, "invalid", "invalid"),
    /**
     * jpg
     */
    HY_IMAGE_JPG(1, "jpg", ".jpg"),

    /**
     * png
     */
    HY_IMAGE_PNG(2, "png", ".png"),

    /**
     * bmp
     */
    HY_IMAGE_BMP(3, "bmp", ".bmp"),

    /**
     * gif
     */
    HY_IMAGE_GIF(4, "gif", ".gif"),

    /**
     * webp
     */
    HY_IMAGE_WEBP(5, "webp", ".webp"),

    /**
     * tiff
     */
    HY_IMAGE_TIFF(6, "tiff", ".tif")
    ;
    private int type;
    private String name;
    private String suffix;

    HYImageTypeEnum(int type, String name, String suffix) {
        this.type = type;
        this.name = name;
        this.suffix =suffix;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public static HYImageTypeEnum fromInt(int type) {
        for (HYImageTypeEnum typeEnum : HYImageTypeEnum.values()){
            if(typeEnum.getType() == type){
                return typeEnum;
            }
        }

        return HYImageTypeEnum.HY_IMAGE_INVALID;
    }

    public static HYImageTypeEnum fromString(String name) {
        for (HYImageTypeEnum typeEnum : HYImageTypeEnum.values()){
            if(typeEnum.getName().equalsIgnoreCase(name)){
                return typeEnum;
            }
        }

        return HYImageTypeEnum.HY_IMAGE_INVALID;
    }

    public static List<String> getAllTypeString(){
        List<String> typeList = new ArrayList<>();

        for (HYImageTypeEnum typeEnum : HYImageTypeEnum.values()){
            typeList.add(typeEnum.getName());
        }

        return typeList;
    }

}
