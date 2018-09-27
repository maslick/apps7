package io.maslick.apps7.ifaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class AbstractUrlBuilder {

    protected String DATE_FORMAT = "";
    protected String URL_PREFIX = "";
    protected String URL_POSTFIX = ".csv";

    public String build(String date) {
        try {
            SimpleDateFormat dfIn = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat dfOut = new SimpleDateFormat(DATE_FORMAT);
            return URL_PREFIX + dfOut.format(dfIn.parse(date)) + URL_POSTFIX;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
