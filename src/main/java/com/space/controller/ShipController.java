package com.space.controller;

import com.space.model.ShipEntity;
import com.space.model.ShipType;
import com.space.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.space.service.utils.ShipSpecificationBuilder.*;

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


        return shipService.findAll(Specification
                        .where(stringSpec("name", name)
                                .and(stringSpec("planet", planet))
                                .and(shipTypeSpec(shipType))
                                .and(prodDateSpec(after, true))
                                .and(prodDateSpec(before, false))
                                .and(intSpec("crewSize", minCrewSize, true))
                                .and(intSpec("crewSize", maxCrewSize, false))
                                .and(doubleSpec("speed", minSpeed, true))
                                .and(doubleSpec("speed", maxSpeed, false))
                                .and(doubleSpec("rating", minRating, true))
                                .and(doubleSpec("rating", maxRating, false))
                                .and(isUsedSpec(isUsed))
                        ),
                PageRequest.of(pageNumber, pageSize, Sort.by(order.getFieldName())));
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


        return shipService.getShipsCount(Specification
                .where(stringSpec("name", name)
                        .and(stringSpec("planet", planet))
                        .and(shipTypeSpec(shipType))
                        .and(prodDateSpec(after, true))
                        .and(prodDateSpec(before, false))
                        .and(intSpec("crewSize", minCrewSize, true))
                        .and(intSpec("crewSize", maxCrewSize, false))
                        .and(doubleSpec("speed", minSpeed, true))
                        .and(doubleSpec("speed", maxSpeed, false))
                        .and(doubleSpec("rating", minRating, true))
                        .and(doubleSpec("rating", maxRating, false))
                        .and(isUsedSpec(isUsed))
                ));
    }

    //3 создаём корабль, POST
    @PostMapping("/ships")
    @ResponseBody
    public ShipEntity createShip(@RequestBody @Valid ShipEntity shipEntity) {

        return shipService.createShip(shipEntity);
    }

    //4 Получаем корабль по ID GET
    @GetMapping("/ships/{id}")
    @ResponseBody
    public ShipEntity getShip(@PathVariable Long id) {

        return shipService.getShip(id);
    }

    //5 Обновляем корабль по ID POST
    @PostMapping("/ships/{id}")
    public ShipEntity updateShip(@PathVariable Long id, @RequestBody ShipEntity shipEntity) {

        return shipService.updateShip(id, shipEntity);
    }

    //6 Удаляем корабль
    @DeleteMapping("/ships/{id}")
    public void deleteShip(@PathVariable Long id) {
        shipService.deleteShip(id);
    }
}
