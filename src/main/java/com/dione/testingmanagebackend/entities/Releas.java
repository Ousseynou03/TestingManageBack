package com.dione.testingmanagebackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Releas implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refRelease;
    private String nomRelease;
    private Date dateLivraison;
    private Date datePrevision;
    private Date dateReelle;

//    @OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER, mappedBy="release", orphanRemoval=true)
//    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
//    private Set<Ticket> tickets;

//    @OneToMany(mappedBy = "release",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY )
//    private Set<Ticket> tickets = new HashSet<>();
}
