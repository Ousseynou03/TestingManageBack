package com.dione.testingmanagebackend.repository;

import com.dione.testingmanagebackend.entities.ScenarioDeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScenarioRepository extends JpaRepository<ScenarioDeTest, Long> {
    @Query(value = "select scenarioTest from ScenarioDeTest scenarioTest where scenarioTest.casDeTest.refCasTest=:id")
    List<ScenarioDeTest> AllScenarioTest(@Param("id") Long id);
}
