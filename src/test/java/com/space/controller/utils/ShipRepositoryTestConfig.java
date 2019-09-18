package com.space.controller.utils;

import com.space.repository.ShipRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@Import({ShipRepository.class})
public class ShipRepositoryTestConfig {

    @Bean
    @Primary
    public ShipRepository shipRepository(){
        ShipRepository mock = Mockito.mock(ShipRepository.class);
//        Mockito.when(mock.findAll())

        return mock;
    }
}
