package com.space.service;

import com.space.model.ShipEntity;
import com.space.repository.ShipRepository;
import com.space.service.utils.ShipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Transactional
@Service("shipService")
public class ShipServiceImpl implements ShipService {

    @Autowired
    private ShipRepository shipRepository;

    @Override
    public ShipEntity getShip(Long id) {
        if (!shipRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return shipRepository.findById(id).orElse(null);
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
        if (shipEntity.getUsed() == null)
            shipEntity.setUsed(false);

        return shipRepository.save(ShipUtil.refreshShipRating(shipEntity));
    }

    @Override
    public void deleteShip(Long id) {
        if (!shipRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        shipRepository.deleteById(id);
    }

    @Override
    public long getShipsCount(Specification<ShipEntity> spec) {
        return shipRepository.count(spec);
    }

    @Override
    public ShipEntity updateShip(Long id, ShipEntity shipEntity) {
        if (!shipRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        ShipEntity oldShip = shipRepository.getOne(id);

        if (shipEntity.getName() != null)
            oldShip.setName(shipEntity.getName());

        if (shipEntity.getPlanet() != null)
            oldShip.setPlanet(shipEntity.getPlanet());

        if (shipEntity.getShipType() != null)
            oldShip.setShipType(shipEntity.getShipType());

        if (shipEntity.getProdDate() != null)
            oldShip.setProdDate(shipEntity.getProdDate());

        if (shipEntity.getUsed() != null)
            oldShip.setUsed(shipEntity.getUsed());

        if (shipEntity.getSpeed() != null)
            oldShip.setSpeed(shipEntity.getSpeed());

        if (shipEntity.getCrewSize() != null)
            oldShip.setCrewSize(shipEntity.getCrewSize());

        return shipRepository.save(ShipUtil.refreshShipRating(oldShip));
    }
}
