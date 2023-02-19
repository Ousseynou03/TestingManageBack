package com.dione.testingmanagebackend.entities;

import com.dione.testingmanagebackend.enums.Types;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.aot.generate.AccessControl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "ticket")
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Ticket implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref_ticket")
    private Long refTicket;
    private String titre;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Types type;
    @ManyToOne
    private Testeur testeur;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Releas release;
    @OneToOne
    public Anomalie anomalies ;
    @ManyToOne
    private CasDeTest casDeTest;
}
