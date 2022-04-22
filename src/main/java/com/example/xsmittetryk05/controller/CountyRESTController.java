package com.example.xsmittetryk05.controller;

import com.example.xsmittetryk05.model.County;
import com.example.xsmittetryk05.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CountyRESTController {

    @Autowired
    CountyRepository countyRepository;

    @GetMapping("/counties")
    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }

    @GetMapping("/")
    public String hej() {
        return "Hello World";
    }

    @GetMapping("/countyxx")
    public List<County> findAllCountyxx() {
        int i1 = 100;
        int i2 = 0;
        int i3 = i1/i2;
        return countyRepository.findAll();
    }

    @GetMapping("/county/{id}")
    public County findCountyById(@PathVariable String id) {
        Optional<County> obj = countyRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }

    }

    @PostMapping("/county")
    @ResponseStatus(HttpStatus.CREATED)
    public County postCounty(@RequestBody County county) {
        System.out.println(county);
        return countyRepository.save(county);
    }


    @PutMapping("/county/{id}")
    public ResponseEntity<County> updateCount(@PathVariable String id, @RequestBody County county) {
        Optional<County> optCounty = countyRepository.findById(id);
        if (optCounty.isPresent()) {
            countyRepository.save(county);
            return new ResponseEntity<County>(county,HttpStatus.OK);
        } else {
            County notfoundCounty = new County();
            notfoundCounty.setName("Jeg kunne ikke finde id=" + id);
            return new ResponseEntity<County>(notfoundCounty, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/county/{id}")
    public ResponseEntity<String> deleteCounty(@PathVariable String id) {
        try {
            countyRepository.deleteById(id);
            return new ResponseEntity<>("Slettet id=" + id, HttpStatus.OK);
        } catch (Exception err){
            return new ResponseEntity<>("Jeg kunnne ikke slet id=" + id, HttpStatus.NOT_FOUND);
        }

    }


}

