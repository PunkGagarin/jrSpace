package com.space.service;

import com.space.model.ShipEntity;

import java.util.List;

public interface ShipService {

    ShipEntity getShip(Long id);

    List<ShipEntity> findAll();

    void updateShip(ShipEntity shipEntity);

    void deleteShip(ShipEntity entity);

}
