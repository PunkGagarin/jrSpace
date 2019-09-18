package com.space.controller;

import com.space.model.entity.ShipEntity;
import com.space.service.SpaceShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SpaceShipController {

    @Autowired
    private SpaceShipService spaceShipService;

    @GetMapping("/ships")
    public List<ShipEntity> getShips(){
        return spaceShipService.findAll();
    }
}
