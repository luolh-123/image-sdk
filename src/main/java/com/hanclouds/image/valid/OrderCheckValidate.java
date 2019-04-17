package com.hanclouds.image.valid;

import com.hanclouds.image.valid.anno.OrderCheck;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/3/6 15:02
 */
public class OrderCheckValidate implements ConstraintValidator<OrderCheck,Object> {
    private List<String> orderList = Arrays.asList("desc", "asc", "ASC", "DESC");

    @Override
    public void initialize(OrderCheck orderCheck) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (null == o) {
            return true;
        }

        if(!(o instanceof String)){
            return false;
        }

        String order = (String) o;
        //可以为空
        if (StringUtils.isEmpty(order)) {
            return true;
        }

        return orderList.contains(order);
    }
}
