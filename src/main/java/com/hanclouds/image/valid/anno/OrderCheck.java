package com.hanclouds.image.valid.anno;

import com.hanclouds.image.valid.OrderCheckValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/6 15:01
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OrderCheckValidate.class)
public @interface OrderCheck {
    String name() default "desc";

    String message() default "order 只能为desc, asc, DESC, ASC";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
