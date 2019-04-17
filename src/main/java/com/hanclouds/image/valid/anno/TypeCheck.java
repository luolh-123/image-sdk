package com.hanclouds.image.valid.anno;

import com.hanclouds.image.valid.TypeCheckValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 图片类型检查
 * @author luolh
 * @version 1.0
 * @date 2019/3/8 15:10
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TypeCheckValidate.class)
public @interface TypeCheck {
    String message() default "图片支持格式：jpg,png,bmp,gif,webp,tiff";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
