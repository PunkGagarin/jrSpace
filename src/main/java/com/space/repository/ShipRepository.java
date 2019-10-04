package com.space.repository;

import com.space.model.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShipRepository extends JpaRepository<ShipEntity, Long>, JpaSpecificationExecutor<ShipEntity> {

}
