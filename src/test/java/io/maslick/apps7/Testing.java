package io.maslick.apps7;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.maslick.apps7.pojo.Data;
import org.junit.Test;

import java.util.List;

public class Testing {

    @Test
    public void superNetwork1() throws UnirestException {
        String csv = Unirest
                .get("https://storage.googleapis.com/expertise-test/supernetwork/report/daily/2017-09-15.csv")
                .asString()
                .getBody();

        System.out.println(csv);

        List<Data> data = CsvNetLoaderSuperNetwork.processInputFile(csv);
        System.out.println("Size: " + data.size());
    }

    @Test
    public void superNetwork2() throws UnirestException {
        String csv = Unirest
                .get("https://storage.googleapis.com/expertise-test/supernetwork/report/daily/2017-09-16.csv")
                .asString()
                .getBody();

        System.out.println(csv);

        List<Data> data = CsvNetLoaderSuperNetwork.processInputFile(csv);
        System.out.println("Size: " + data.size());
    }

    @Test
    public void adUmbrella1() throws UnirestException {
        String csv = Unirest
                .get("https://storage.googleapis.com/expertise-test/reporting/adumbrella/adumbrella-15_9_2017.csv")
                .asString()
                .getBody();

        System.out.println(csv);

        List<Data> data = CsvNetLoaderAdUmbrella.processInputFile(csv);
        System.out.println("Size: " + data.size());
    }

    @Test
    public void AdUmbrella2() throws UnirestException {
        String csv = Unirest
                .get("https://storage.googleapis.com/expertise-test/reporting/adumbrella/adumbrella-16_9_2017.csv")
                .asString()
                .getBody();

        System.out.println(csv);

        List<Data> data = CsvNetLoaderAdUmbrella.processInputFile(csv);
        System.out.println("Size: " + data.size());
    }
}
