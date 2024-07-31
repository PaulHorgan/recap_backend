package com.example.demo.rest;


import com.example.demo.dtos.EmployeesDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://34.147.222.0")
@RestController
public class BuyerController {

    private final BuyerService service;

    public BuyerController(BuyerService service) {
        this.service = service;
    }

    @GetMapping("buyer/get/all")
    public List<BuyerDto> getAllBuyers () {
        return service.getAll();
    }

    @GetMapping("buyer/get/{id}")
    public ResponseEntity<?> getBuyerById (@PathVariable Integer id) {
        return service.getBuyer(id);
    }

    @PostMapping("buyer/add")
    public ResponseEntity<BuyerDto> createBuyer(@RequestBody Buyer newBuyer){
        return service.createBuyer(newBuyer);
    }

    @DeleteMapping("buyer/remove/{id}")
    public ResponseEntity<?> removeBuyer(@PathVariable Integer id) {
        return service.removeBuyer(id);
    }

}