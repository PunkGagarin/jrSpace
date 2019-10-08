package com.space.service;

import com.space.model.ShipEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ShipService {

    ShipEntity getShip(Long id);

    List<ShipEntity> findAll();

    List<ShipEntity> findAll(Pageable pageable);

    List<ShipEntity> findAll(Specification<ShipEntity> spec, Pageable pageable);

    ShipEntity updateShip(Long id, ShipEntity shipEntit);

    ShipEntity createShip(ShipEntity shipEntity);

    void deleteShip(Long id);

    long getShipsCount(Specification<ShipEntity> spec);

}
