package com.dione.testingmanagebackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ScenarioDeTest implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refScenario;
    @Column(length = 300)
    private String scenario;
    @ManyToOne
    @JoinColumn(nullable = false)
    private CasDeTest casDeTest;
}