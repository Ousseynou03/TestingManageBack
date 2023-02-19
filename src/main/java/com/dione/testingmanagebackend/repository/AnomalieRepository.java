package com.dione.testingmanagebackend.repository;

import com.dione.testingmanagebackend.entities.Anomalie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnomalieRepository extends JpaRepository<Anomalie, Long> {
}
