package io.maslick.apps7.service;

import io.maslick.apps7.ifaces.IValidator;
import io.maslick.apps7.repo.ReportRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ValidatorAlreadySaved implements IValidator {

    @Autowired
    private ReportRepo repo;

    private Logger logger = LoggerFactory.getLogger(ValidatorAlreadySaved.class);

    @Override
    public boolean isOk(String network, String date, String original) {

        try {
            Date d = new SimpleDateFormat("dd.MM.yyyy").parse(date);
            if (repo.findAllByDateAndNetwork(d, network).size() > 0) {
                logger.error("Report for that date is already saved");
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
