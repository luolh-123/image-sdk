package com.hanclouds.image.valid.anno;

import com.hanclouds.image.valid.BytesCheckValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/23 13:12
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BytesCheckValidate.class)
public @interface BytesCheck {
    long min() default 0L;

    long max() default 9223372036854775807L;

    String message() default "bytes length is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
