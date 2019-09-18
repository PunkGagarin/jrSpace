package com.space.service;


import com.space.controller.utils.TestDataSourceConfig;
import com.space.model.entity.ShipEntity;
import com.space.service.utils.ShipUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDataSourceConfig.class})
public class ShipServiceTest {


    @Autowired
    private ShipService shipService;

    @Test
    public void test(){
          ShipEntity ship =  shipService.findAll().get(0);
          double prev = ship.getRating();
          ship.setProdDate(new Date(32998274577071L));
        ShipUtil.refreshShipRating(ship);
        Assert.assertNotEquals("Не изменились данные!", prev, ship.getRating());
        System.out.println("Предыдущий рейт: \t" + prev + "\nНовый рейт: \t\t" + ship.getRating());
    }
}
