package com.codevergence.demo.masterdata.repository;

import com.codevergence.demo.masterdata.model.entity.Placement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacementRepository extends JpaRepository<Placement, Long> {
}
