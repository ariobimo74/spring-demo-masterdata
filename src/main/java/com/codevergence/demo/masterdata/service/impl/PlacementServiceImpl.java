package com.codevergence.demo.masterdata.service.impl;

import com.codevergence.demo.masterdata.model.entity.Placement;
import com.codevergence.demo.masterdata.repository.PlacementRepository;
import com.codevergence.demo.masterdata.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlacementServiceImpl implements PlacementService
{
    @Autowired
    private PlacementRepository placementRepository;

    @Override
    public List<Placement> getAll()
    {
        List<Placement> placementList = placementRepository.findAll();
        List<Placement> placements = new ArrayList<Placement>();

        for (int i = 0; i < placementList.size(); i++)
        {
            if (!placementList.get(i).isDelete())
            {
                placements.add(placementList.get(i));
            }
        }
        return placements;
    }

    @Override
    public Optional<Placement> getById(long id) {
        if (!placementRepository.findById(id).get().isDelete())
        {
            return placementRepository.findById(id);
        }
        else
        {
            return Optional.empty();
        }
    }
}
