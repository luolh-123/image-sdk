package com.hanclouds.image.valid;

import com.hanclouds.image.valid.anno.BytesCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/23 13:17
 */
public class BytesCheckValidate implements ConstraintValidator<BytesCheck, Object> {
    private long min;
    private long max;

    @Override
    public void initialize(BytesCheck bytesCheck) {
        this.min = bytesCheck.min();
        this.max = bytesCheck.max();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(null == o){
            return true;
        }

       if(!(o instanceof byte[])){
            return false;
       }

       byte[] values = (byte[]) o;
        return values.length >= min && values.length <= max;
    }
}
