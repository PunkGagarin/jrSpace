package com.space.service.utils;

import com.space.model.entity.ShipEntity;
import org.springframework.stereotype.Component;

@Component
public class ShipUtil {

    private ShipUtil(){

    }

    public static double calculateShipRating(ShipEntity entity){

        double usedShipCoef = entity.getUsed() == null ? 1 : (!entity.getUsed() ? 0.5 : 1);
        //TODO: use Calendar class instead of deprecated.
        int prodDate = entity.getProdDate().getYear() ;

        return Math.round((entity.getSpeed() * 80 *usedShipCoef)/(3019 - prodDate + 1) * 100)/100.0;
    }

    public static ShipEntity refreshShipRating(ShipEntity entity){
        entity.setRating(calculateShipRating(entity));
        return entity;
    }
}
