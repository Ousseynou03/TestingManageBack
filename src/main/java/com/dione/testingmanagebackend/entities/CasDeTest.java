package com.dione.testingmanagebackend.entities;



import com.dione.testingmanagebackend.enums.Resultat;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CasDeTest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refCasTest;
    @Enumerated(EnumType.STRING)
    @Column(length = 38)
    private Resultat resultat;
//    @JsonBackReference
//    @JsonIgnoreProperties
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "casDeTest")
//    private List<ScenarioDeTest> scenarioDeTests = new ArrayList<>();

//    public void setScenarioDeTests(ScenarioDeTest scenarioDeTests) {
//        this.scenarioDeTests = (List<ScenarioDeTest>) scenarioDeTests;
//    }
//
//    public List<ScenarioDeTest> getScenarioDeTests(){
//        return this.scenarioDeTests;
//    }
}