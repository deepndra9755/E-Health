package io.health.repository;

import io.health.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRespo extends JpaRepository<Report,Integer> {

//mysql> select * from report JOIN patient ON  report.patient_id=patient.pid JOIN cbcreport on cbcreport.report_id=report.report_id;
    @Query("SELECT r FROM Report r JOIN FETCH r.patient JOIN FETCH r.reports c WHERE r.patient.pid = :patientId")
    List<Report> findReportsWithPatientAndCBCReportsByPatientId(Integer patientId);

    List<Report> findByPatientPid(Integer patientId);




}


