package io.maslick.apps7.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReportRepo extends JpaRepository<DailyReport, Long> {
    List<DailyReport> findAllByDateAndNetwork(Date date, String network);
    List<DailyReport> findAllByNetwork(String network);
}
