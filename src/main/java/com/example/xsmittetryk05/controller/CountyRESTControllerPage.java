package com.example.xsmittetryk05.controller;

import com.example.xsmittetryk05.model.County;
import com.example.xsmittetryk05.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CountyRESTControllerPage {

    @Autowired
    CountyRepository countyRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }

    @GetMapping("/countysortxx")
    public ResponseEntity<List<County>> getPageOfScreeningsxx(@RequestParam(defaultValue = "id,desc") String[] sort) {
        for (String s: sort) {
            System.out.println(s);
        }
        List counties = countyRepository.findAll();
        return new ResponseEntity<>(counties, HttpStatus.OK);
    }


    @GetMapping("/countysort")
    public ResponseEntity<List<County>> getPageOfScreenings(@RequestParam(defaultValue = "id,desc") String[] sort) {
        for (String s: sort) {
            System.out.println(s);
        }

        List<Sort.Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            for (String sortOrder: sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
        }

        List counties = countyRepository.findAll(Sort.by(orders));
        if (counties.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(counties, HttpStatus.OK);
    }

    @GetMapping("/countysortpage")
    public ResponseEntity<Map<String, Object>>  getCountySortAndPage (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort
    ) {
        List<Sort.Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            for (String sortOrder: sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
        }

        Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
        Page<County> pageKommune = countyRepository.findAll(pagingSort);
        List<County> kommune = pageKommune.getContent();

        if (kommune.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Map<String, Object> response = new HashMap<>();
        response.put("county", kommune);
        response.put("currentPage", pageKommune.getNumber());
        response.put("totalItems", pageKommune.getTotalElements());
        response.put("totalPages", pageKommune.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("countypagexx")
    public ResponseEntity<List<County>> getPageOfCounties() {
        int page = 4;
        int size = 5;
        PageRequest countyPage = PageRequest.of(page, size);
        Page<County> pageCounty = countyRepository.findAll(countyPage);
        List<County> lstCounties = pageCounty.getContent();
        if (lstCounties.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(lstCounties, HttpStatus.OK);
    }

    @GetMapping("/countypage")
    public ResponseEntity<Map<String, Object>> getPageOfKommuner(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable paging = PageRequest.of(page, size);
        Page<County> pageKommune = countyRepository.findAll(paging);

        List<County> kommuner = pageKommune.getContent();

        if (kommuner.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Map<String, Object> response = new HashMap<>();
        response.put("counties", kommuner);
        response.put("currentPage", pageKommune.getNumber());
        response.put("totalItems", pageKommune.getTotalElements());
        response.put("totalPages", pageKommune.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/countypageuden")
    public ResponseEntity<Map<String, Object>> getPageOfKommunerUden(
            @RequestParam int page,
            @RequestParam int size) {

        Pageable paging = PageRequest.of(page, size);
        Page<County> pageKommune = countyRepository.findAll(paging);

        List<County> kommuner = pageKommune.getContent();

        if (kommuner.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Map<String, Object> response = new HashMap<>();
        response.put("counties", kommuner);
        response.put("currentPage", pageKommune.getNumber());
        response.put("totalItems", pageKommune.getTotalElements());
        response.put("totalPages", pageKommune.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}




