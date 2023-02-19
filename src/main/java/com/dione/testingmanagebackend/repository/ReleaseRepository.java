package com.dione.testingmanagebackend.repository;

import com.dione.testingmanagebackend.entities.Releas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReleaseRepository extends JpaRepository<Releas, Long> {

    //Récupération de la liste des tickets pour chaque release
    @Query(value = "SELECT * FROM releas LEFT JOIN ticket ON releas.ref_release = ticket.release_ref_release", nativeQuery = true)
    List<Object[]> findReleasesWithTickets();


    //Récupére le nombre total de ticket pour chaque release
    @Query(value = "SELECT releas.ref_release, COUNT(ticket.ref_ticket) as total_tickets FROM " +
            "releas LEFT JOIN ticket ON releas.ref_release = ticket.release_ref_release " +
            "GROUP BY releas.ref_release", nativeQuery = true)
    List<Object[]> findReleasesWithTotalTickets();
}
