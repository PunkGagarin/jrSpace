package com.space.service.utils;

import com.space.controller.utils.TestDataSourceConfig;
import com.space.model.entity.ShipEntity;
import com.space.repository.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDataSourceConfig.class})
public class ShipUtilTest {

    @Autowired
    private ShipRepository shipRepository;

    @Test
    public void testCalculateShipRating(){
        ShipEntity entity =  shipRepository.findAll().get(0);

        System.out.println(ShipUtil.calculateShipRating(entity));

    }

}
