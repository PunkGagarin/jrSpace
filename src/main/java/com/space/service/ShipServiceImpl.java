package com.space.service;

import com.space.model.ShipEntity;
import com.space.repository.ShipRepository;
import com.space.service.utils.ShipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class ShipServiceImpl implements ShipService {

    @Autowired
    private ShipRepository shipRepository;

    @Override
    public ShipEntity getShip(Long id) {
        Optional<ShipEntity> ship = shipRepository.findById(id);

        return ship.get();
    }

    @Override
    public List<ShipEntity> findAll() {
        return shipRepository.findAll();
    }

    @Override
    public void updateShip(ShipEntity shipEntity) {
        shipRepository.save(ShipUtil.refreshShipRating(shipEntity));
    }

    @Override
    public void deleteShip(ShipEntity entity) {
        shipRepository.delete(entity);
    }


}
