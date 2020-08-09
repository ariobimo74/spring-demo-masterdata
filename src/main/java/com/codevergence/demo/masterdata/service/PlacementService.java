package com.codevergence.demo.masterdata.service;

import com.codevergence.demo.masterdata.model.entity.Placement;

import java.util.List;
import java.util.Optional;

public interface PlacementService
{
    List<Placement> getAll();

    Optional<Placement> getById(long id);
}
