package com.space.service;

import com.space.model.ShipEntity;
import com.space.repository.ShipRepository;
import com.space.service.utils.ShipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Service("shipService")
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
    public List<ShipEntity> findAll(Pageable pageable) {
        return shipRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ShipEntity> findAll(Specification<ShipEntity> spec, Pageable pageable) {
        return shipRepository.findAll(spec, pageable).getContent();
    }

    @Override
    public ShipEntity createShip(ShipEntity shipEntity) {
        if(shipEntity.getUsed() == null)
            shipEntity.setUsed(false);

       return shipRepository.save(ShipUtil.refreshShipRating(shipEntity));
    }

    @Override
    public void deleteShip(Long id) {
        shipRepository.deleteById(id);
    }

    @Override
    public long getShipsCount(Specification<ShipEntity> spec) {
        return shipRepository.count(spec);
    }

    @Override
    public ShipEntity updateShip(Long id, ShipEntity shipEntity) {
        return shipRepository.save(ShipUtil.refreshShipRating(shipEntity));
    }


}
