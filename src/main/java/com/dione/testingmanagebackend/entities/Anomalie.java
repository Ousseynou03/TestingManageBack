package com.dione.testingmanagebackend.entities;


import com.dione.testingmanagebackend.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "anomalie")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Anomalie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refAnomalie;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Criticite criticite;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Priorite priorite;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Statut statut;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private EnCours enCours;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Cloturee cloturee;
}