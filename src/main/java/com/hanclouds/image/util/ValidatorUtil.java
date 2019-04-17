package com.hanclouds.image.util;

import cn.hutool.core.map.MapUtil;
import com.hanclouds.image.exception.HanCloudsClientException;
import org.junit.Assert;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/2/28 13:49
 */
public class ValidatorUtil {
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    private static <T> Map<String, String> validate(T t, Class... groups) {
        Validator validator = validatorFactory.getValidator();
        Set validateResult = validator.validate(t, groups);
        if (validateResult.isEmpty()) {
            return Collections.emptyMap();
        } else {
            LinkedHashMap errors = new LinkedHashMap();
            Iterator iterator = validateResult.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation violation = (ConstraintViolation) iterator.next();
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            return errors;
        }
    }

    private static Map<String, String> validateList(Collection<?> collection) {
        Assert.assertNotNull(collection);
        Iterator iterator = collection.iterator();
        Map errors;
        do {
            if (!iterator.hasNext()) {
                return Collections.emptyMap();
            }
            Object object = iterator.next();
            errors = validate(object, new Class[0]);
        } while (errors.isEmpty());

        return errors;
    }

    private static Map<String, String> validateObject(Object first, Object... objects) {
        if (objects != null && objects.length > 0) {
            return validateList(Arrays.asList(first, objects));
        } else {
            return validate(first, new Class[0]);
        }
    }

    public static void validate(Object param) throws HanCloudsClientException {
        Map<String, String> map = validateObject(param);
        if (MapUtil.isNotEmpty(map)) {
            throw new HanCloudsClientException(map.toString());
        }
    }
}
