package com.spring.utils.mvc.validation;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationTest {


    @Test
    void beanValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Item item = new Item();
        item.setItemName(" ");
        item.setPrice(1000000000);
        item.setQuantity(0010101010101);

        Set<ConstraintViolation<Item>> validate = validator.validate(item);
        for (ConstraintViolation<Item> itemConstraintViolation : validate) {validation
            System.out.println("itemConstraintViolation = " + itemConstraintViolation);
            System.out.println("itemConstraintViolation.getMessage() = " + itemConstraintViolation.getMessage());
        }

    }
}
