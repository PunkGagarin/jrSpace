package com.space.controller;

import com.space.model.ShipEntity;
import com.space.model.ShipType;
import com.space.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody // можно заменить эти 2 аннотации на @RestController
@RequestMapping("/rest")
public class ShipController {


    @Autowired
    private ShipService shipService;

    //1 Получаем список всех кораблей или всех кораблей по филтрам, GET
    @GetMapping("/ships")
    @ResponseBody
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
                                     @RequestParam(value = "order", required = false, defaultValue = "ID") ShipOrder order,
                                     @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize) {



        return shipService.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(order.getFieldName())));
    }

    //2 получаем кол-во всех кораблей или всех кораблей с заданными параметрами GET
    @GetMapping("/ships/count")
    public long getShipsCount(@RequestParam(value = "name", required = false) String name,
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
                              @RequestParam(value = "maxRating", required = false) Double maxRating) {


        return shipService.getShipsCount();
    }

    //3 создаём корабль, POST
    @PostMapping("/ships")
    public void createShip(@RequestBody ShipEntity shipEntity) {

        shipService.createShip(shipEntity);
    }

    //4 Получаем корабль по ID GET
    @GetMapping("/ships/{id}")
    @ResponseBody
    public ShipEntity getShip(@PathVariable Long id) {

        return shipService.getShip(id);
    }

    //5 Обновляем корабль по ID POST
    @PostMapping("/ships/{id}")
    public ShipEntity updateShip( @PathVariable Long id, @RequestBody ShipEntity shipEntity) {

       return shipService.updateShip(id, shipEntity);
    }

    //6 Удаляем корабль
    @DeleteMapping("/ships/{id}")
    public void deleteShip(@PathVariable Long id){
        shipService.deleteShip(id);
    }
}
