package com.investbridge.auth.repository;

import com.investbridge.auth.entity.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {
    List<Distributor> findByLocation(String location);
}
