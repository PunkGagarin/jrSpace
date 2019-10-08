package com.space.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateBetweenValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateBetween {

    String message() default "Invalid date";

    int min();
    int max();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
