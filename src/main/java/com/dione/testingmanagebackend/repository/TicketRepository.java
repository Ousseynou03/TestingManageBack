package com.dione.testingmanagebackend.repository;

import com.dione.testingmanagebackend.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@SuppressWarnings("unused")
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "select ticket from Ticket ticket where ticket.release.refRelease =:id")
    List<Ticket> AllTicketRelease(@Param("id") Long id);

    @Query(value = "SELECT\n" +
            "(SELECT COUNT(*) FROM ticket t WHERE t.release_ref_release=:id) as TicketToTal, \n" +
            "(SELECT COUNT(*) FROM ticket t WHERE t.cas_de_test_ref_cas_test IS NOT NULL and t.release_ref_release=:id) as TicketCouvert, \n" +
            "(SELECT COUNT(*) FROM ticket t, cas_de_test c WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"OK\" and t.release_ref_release=:id) as OK, \n" +
            "(SELECT COUNT(*) FROM ticket t, cas_de_test c WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"KO\" and t.release_ref_release=:id) as KO, \n" +
            "(SELECT COUNT(*) FROM ticket t, cas_de_test c WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"Non_Teste\" and t.release_ref_release=:id) as NonTeste, \n" +
            "(SELECT COUNT(*) FROM ticket t, cas_de_test c WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"Abandonnes\" and t.release_ref_release=:id) as Abandonnes, \n" +
            "(SELECT COUNT(*) FROM ticket t, cas_de_test c WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"Bloquee\" and t.release_ref_release=:id) as Bloquee, \n" +
            "(SELECT COUNT(*) FROM ticket t, cas_de_test c WHERE c.ref_cas_test=t.cas_de_test_ref_cas_test and c.resultat=\"Hors_Perimetre\" and t.release_ref_release=:id) as Hors_Perimetre", nativeQuery = true)
    Object Vision(@Param("id") Long id);

    @Query(value = "SELECT\n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"BLOQUANTE\" and a.en_cours=\"A_TRAITES\" and t.release_ref_release=:id) as BLAT, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"BLOQUANTE\" and a.en_cours=\"CORRIGEES\" and t.release_ref_release=:id) as BLCO, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"BLOQUANTE\" and a.en_cours=\"VERIFICATION\" and t.release_ref_release=:id) as BLVE, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"BLOQUANTE\" and a.cloturee=\"ValidationCorrectifs\" and t.release_ref_release=:id) as BLVC, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"BLOQUANTE\" and a.cloturee=\"Rejetees\" and t.release_ref_release=:id) as BLRE, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"BLOQUANTE\" and a.cloturee=\"ProblemeDocumentaire\" and t.release_ref_release=:id) as BLPD, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"BLOQUANTE\" and a.cloturee=\"ArbitrageProjetEvolution\" and t.release_ref_release=:id) as BLAPE",
    nativeQuery = true)
    Object VisionAnomalieBloquant(@Param("id") Long id);

    @Query(value = "SELECT\n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MAJEURE\" and a.en_cours=\"A_TRAITES\" and t.release_ref_release=:id) as BLAT, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MAJEURE\" and a.en_cours=\"CORRIGEES\" and t.release_ref_release=:id) as BLCO, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MAJEURE\" and a.en_cours=\"VERIFICATION\" and t.release_ref_release=:id) as BLVE, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MAJEURE\" and a.cloturee=\"ValidationCorrectifs\" and t.release_ref_release=:id) as BLVC, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MAJEURE\" and a.cloturee=\"Rejetees\" and t.release_ref_release=:id) as BLRE, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MAJEURE\" and a.cloturee=\"ProblemeDocumentaire\" and t.release_ref_release=:id) as BLPD, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MAJEURE\" and a.cloturee=\"ArbitrageProjetEvolution\" and t.release_ref_release=:id) as BLAPE"
            ,nativeQuery = true)
    Object VisionAnomalieMajeur(@Param("id") Long id);

    @Query(value = "SELECT\n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MINEURE\" and a.en_cours=\"A_TRAITES\" and t.release_ref_release=:id) as BLAT, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MINEURE\" and a.en_cours=\"CORRIGEES\" and t.release_ref_release=:id) as BLCO, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MINEURE\" and a.en_cours=\"VERIFICATION\" and t.release_ref_release=:id) as BLVE, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MINEURE\" and a.cloturee=\"ValidationCorrectifs\" and t.release_ref_release=:id) as BLVC, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MINEURE\" and a.cloturee=\"Rejetees\" and t.release_ref_release=:id) as BLRE, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MINEURE\" and a.cloturee=\"ProblemeDocumentaire\" and t.release_ref_release=:id) as BLPD, \n" +
            "(SELECT COUNT(*) FROM ticket t, anomalie a WHERE t.anomalies_ref_anomalie=a.ref_anomalie and a.criticite=\"MINEURE\" and a.cloturee=\"ArbitrageProjetEvolution\" and t.release_ref_release=:id) as BLAPE",
    nativeQuery = true)
    Object VisionAnomalieMineur(@Param("id")Long id);
}
