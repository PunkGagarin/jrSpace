package com.space.model.repository;

import com.space.controller.utils.TestDataSourceConfig;
import com.space.repository.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDataSourceConfig.class})
public class ShipRepoTest {

    @Autowired
    private ShipRepository shipRepository;

    @Test
    public void test() {
        Assert.notNull(shipRepository.findAll(), "repo error");
    }
}
