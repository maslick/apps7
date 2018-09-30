package io.maslick.apps7.repo;

import io.maslick.apps7.ifaces.IPersister;
import io.maslick.apps7.pojo.Report;
import io.maslick.apps7.service.ValidatorAlreadySaved;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Persister implements IPersister {

    @Autowired
    private ReportRepo repo;

    private Logger logger = LoggerFactory.getLogger(ValidatorAlreadySaved.class);

    @Override
    public void invoke(String network, List<Report> data) {
        List<DailyReport> list = data.stream().map(report ->
                DailyReport.builder()
                        .network(network)
                        .date(report.getDate())
                        .app(report.getApp())
                        .platform(report.getPlatform())
                        .requests(report.getRequests())
                        .impressions(report.getImpressions())
                        .revenue(report.getRevenue())
                        .currency(report.getCurrency())
                        .build()
        ).collect(Collectors.toList());

        if (repo != null) {
            repo.saveAll(list);
            logger.info("saved to DB");
        }
        else
            logger.warn("nothing to save!");
    }
}
