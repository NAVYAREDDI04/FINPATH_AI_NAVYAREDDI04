package com.investbridge.auth.controller;

import com.investbridge.auth.entity.Distributor;
import com.investbridge.auth.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/distributors")
public class DistributorController {

    @Autowired
    private DistributorService service;

    @PostMapping
    public Distributor createDistributor(@RequestBody Distributor distributor) {
        return service.saveDistributor(distributor);
    }

    @GetMapping
    public List<Distributor> getAllDistributors() {
        return service.getAllDistributors();
    }

    @GetMapping("/location/{location}")
    public List<Distributor> getDistributorsByLocation(@PathVariable String location) {
        return service.findNearestDistributors(location);
    }
}
