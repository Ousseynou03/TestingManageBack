package com.dione.testingmanagebackend.repository;

import com.dione.testingmanagebackend.entities.CasDeTest;
import com.dione.testingmanagebackend.entities.ScenarioDeTest;
import com.dione.testingmanagebackend.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasDeTestRepository extends JpaRepository<CasDeTest, Long> {
    @Query(value = "SELECT\n" +
            "(SELECT COUNT(*) FROM cas_de_test c, ticket t WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and t.release_ref_release=:id) as CasDeTesTotal, \n" +
            "(SELECT COUNT(*) FROM ticket WHERE ticket.cas_de_test_ref_cas_test IS NOT NULL ) as CasDeTestLieTicket, \n" +
            "(SELECT COUNT(*) FROM cas_de_test c, ticket t WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"OK\" and t.release_ref_release=:id) as CasDeTesOK,\n" +
            "(SELECT COUNT(*) FROM cas_de_test c, ticket t WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"KO\" and t.release_ref_release=:id) as CasDeTesKO,\n" +
            "(SELECT COUNT(*) FROM cas_de_test c, ticket t WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"Bloquee\" and t.release_ref_release=:id) as CasDeTesBloquee,\n" +
            "(SELECT COUNT(*) FROM cas_de_test c, ticket t WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"Non_Teste\" and t.release_ref_release=:id) as CasDeTesNonTeste,\n" +
            "(SELECT COUNT(*) FROM cas_de_test c, ticket t WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"Hors_Perimetre\" and t.release_ref_release=:id) as CasDeTesHorsPerimetre",
    nativeQuery = true)
    Object CasVisionTest(@Param("id") Long id);
}
