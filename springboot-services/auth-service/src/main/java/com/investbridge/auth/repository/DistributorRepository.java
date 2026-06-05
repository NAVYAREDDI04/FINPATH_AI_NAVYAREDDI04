package com.investbridge.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.investbridge.auth.entity.Distributor;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {
    List<Distributor> findByCity(String city);
}
