package com.space.controller.utils;


import com.space.service.ShipService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ShipService.class})
public class ShipServiceTestConfig {

//    @Bean
//    @Primary
//     public SpaceShipService spaceShipService(){
//        return Mockito.mock(SpaceShipService.class);
//    }
}
