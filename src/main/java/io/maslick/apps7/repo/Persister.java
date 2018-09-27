package io.maslick.apps7.repo;

import io.maslick.apps7.ifaces.IPersister;
import io.maslick.apps7.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Persister implements IPersister {

    @Autowired
    private ReportRepo repo;

    @Override
    public void invoke(List<Report> data) {
        List<Data> list = data.stream().map(report -> Data.builder()
                .date(report.getDate())
                .app(report.getApp())
                .platform(report.getPlatform())
                .requests(report.getRequests())
                .impressions(report.getImpressions())
                .revenue(report.getRevenue())
                .currency(report.getCurrency())
                .build()).collect(Collectors.toList());

        System.out.println("Persisting report...");

        if (repo != null) {
            repo.saveAll(list);
            System.out.println(repo.findAll().size());
            System.out.println("SAVED TO DB!");
        }
    }
}
