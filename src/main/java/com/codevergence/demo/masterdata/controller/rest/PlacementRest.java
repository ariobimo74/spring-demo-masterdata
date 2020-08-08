package com.codevergence.demo.masterdata.controller.rest;

import com.codevergence.demo.masterdata.model.entity.Placement;
import com.codevergence.demo.masterdata.service.interf.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/placements")
public class PlacementRest
{
    @Autowired
    private PlacementService placementService;

    @GetMapping
    public List<Placement> getAll()
    {
        return placementService.getAll();
    }

    @GetMapping(path = "{/id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id)
    {
        if (placementService.getById(id).isPresent())
        {
            return new ResponseEntity<>(placementService.getById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
