package com.dione.testingmanagebackend.repository;

import com.dione.testingmanagebackend.entities.Testeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteurRepository extends JpaRepository<Testeur, Long> {
}
