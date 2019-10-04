package com.space.model.repository;

import com.space.controller.utils.TestDataSourceConfig;
import com.space.model.ShipEntity;
import com.space.model.ShipType;
import com.space.repository.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import java.util.Date;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDataSourceConfig.class})
public class ShipRepoTest {

    ShipEntity shipEntity = new ShipEntity(41L, "123456789", "Earth", ShipType.MILITARY, new Date(32998274577071L), true, 0.8, 14, 6.4);

    @Autowired
    private ShipRepository shipRepository;

    @Test
    public void test() {
        Assert.assertNotNull("repo error", shipRepository.findAll());
    }

    @Test
    public void testCreateShip() {


        Assert.assertEquals(shipEntity, shipRepository.save(shipEntity));
    }
}
