package com.space.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateBetweenValidator implements ConstraintValidator<DateBetween, Date> {

    private int minYear;
    private int maxYear;

    @Override
    public void initialize(DateBetween constraintAnnotation) {
        minYear = constraintAnnotation.min();
        maxYear = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(value);

        int year = calendar.get(Calendar.YEAR);

        return (minYear == 0 || year >= minYear) && (maxYear == 0 || year <= maxYear);
    }
}
