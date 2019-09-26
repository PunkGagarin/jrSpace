package com.space.controller;

import com.space.model.ShipEntity;
import com.space.model.ShipType;
import com.space.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody // можно заменить эти 2 аннотации на @RestController
@RequestMapping("/rest")
public class ShipController {

    @Autowired
    private ShipService shipService;

    @GetMapping("/ships")
    public List<ShipEntity> getShips(@RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "planet", required = false) String planet,
                                      @RequestParam(value = "shipType", required = false) ShipType shipType,
                                      @RequestParam(value = "after", required = false) Long after,
                                      @RequestParam(value = "before", required = false) Long before,
                                      @RequestParam(value = "isUsed", required = false) Boolean isUsed,
                                      @RequestParam(value = "minSpeed", required = false) Double minSpeed,
                                      @RequestParam(value = "maxSpeed", required = false) Double maxSpeed,
                                      @RequestParam(value = "minCrewSize", required = false) Integer minCrewSize,
                                      @RequestParam(value = "maxCrewSize", required = false) Integer maxCrewSize,
                                      @RequestParam(value = "minRating", required = false) Double minRating,
                                      @RequestParam(value = "maxRating", required = false) Double maxRating,
                                      @RequestParam(value = "order", required = false) ShipOrder order,
                                      @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                      @RequestParam(value = "pageSize", required = false) Integer pageSize){



        return shipService.findAll();
    }
}
