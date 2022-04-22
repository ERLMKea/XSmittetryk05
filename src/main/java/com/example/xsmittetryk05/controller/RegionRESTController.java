package com.example.xsmittetryk05.controller;

import com.example.xsmittetryk05.model.Region;
import com.example.xsmittetryk05.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class RegionRESTController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/regions")
    public List<Region> getAllCounties() {
        return regionRepository.findAll();
    }

    @PostMapping("/region")
    @ResponseStatus(HttpStatus.CREATED)
    public Region postCounty(@RequestBody Region region) {
        System.out.println(region);
        return regionRepository.save(region);
    }

    @GetMapping("/regionx/{id}")
    public Region findRegionByIdx(@PathVariable String id) {
        Optional<Region> obj = regionRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }

    }

    @GetMapping("/region/{id}")
    public ResponseEntity<Region> findRegionByIdr(@PathVariable String id) {
        Optional<Region> obj = regionRepository.findById(id);
        if (obj.isPresent()) {
            return new ResponseEntity<>(obj.get(), HttpStatus.OK);
        } else {
            Region reg = new Region();
            reg.setName("Not Found");
            return new ResponseEntity<>(reg, HttpStatus.NOT_FOUND);
        }

    }



}
