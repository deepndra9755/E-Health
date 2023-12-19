package io.health.repository;

import io.health.entities.CBCReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CBCRepos extends JpaRepository<CBCReport,Integer> {
}
