package com.space.service.utils;

import com.space.model.ShipEntity;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class ShipUtil {

    private ShipUtil(){

    }

    public static double calculateShipRating(ShipEntity entity){

        boolean isUsed = entity.getUsed();

        //true = 0.5
        double usedShipCoef = isUsed ? 0.5 : 1;

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(entity.getProdDate());
        int prodYear = calendar.get(Calendar.YEAR);

        return Math.round((entity.getSpeed() * 80 *usedShipCoef)/(3019 - prodYear + 1) * 100)/100.0;
    }

    public static ShipEntity refreshShipRating(ShipEntity entity){
        entity.setRating(calculateShipRating(entity));
        return entity;
    }
}
