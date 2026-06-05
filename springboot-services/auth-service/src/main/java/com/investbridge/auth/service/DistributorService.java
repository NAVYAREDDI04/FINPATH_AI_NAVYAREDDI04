package com.investbridge.auth.service;

import com.investbridge.auth.entity.Distributor;
import com.investbridge.auth.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorService {

    @Autowired
    private DistributorRepository distributorRepository;

    public List<Distributor> findNearestDistributors(String location) {
        return distributorRepository.findByLocation(location);
    }

    public List<Distributor> getAllDistributors() {
        return distributorRepository.findAll();
    }

    public Distributor saveDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }
}
