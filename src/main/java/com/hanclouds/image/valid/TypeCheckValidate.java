package com.hanclouds.image.valid;


import com.hanclouds.image.model.HYImageTypeEnum;
import com.hanclouds.image.valid.anno.TypeCheck;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/6 15:02
 */
public class TypeCheckValidate implements ConstraintValidator<TypeCheck, Object> {
    @Override
    public void initialize(TypeCheck typeCheck) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (null == o) {
            return true;
        }

        if (!(o instanceof String)) {
            return false;
        }
        String type = (String) o;
        //可以为空
        if (StringUtils.isEmpty(type)) {
            return true;
        }

        return HYImageTypeEnum.getAllTypeString().contains(type.toLowerCase());
    }
}
