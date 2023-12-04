package io.health.repository;

import io.health.entities.CBCReport;
import io.health.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRespo extends JpaRepository<Report,Integer> {


}


