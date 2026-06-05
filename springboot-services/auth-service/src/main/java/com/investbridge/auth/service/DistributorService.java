package com.investbridge.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investbridge.auth.entity.Distributor;
import com.investbridge.auth.repository.DistributorRepository;

@Service
public class DistributorService {

    @Autowired
    private DistributorRepository distributorRepository;

    public List<Distributor> findNearestDistributors(String city) {
        return distributorRepository.findByCity(city);
    }

    public List<Distributor> getAllDistributors() {
        return distributorRepository.findAll();
    }

    public Distributor saveDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }
}
