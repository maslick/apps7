package io.maslick.apps7;

import io.maslick.apps7.pojo.Report;
import io.maslick.apps7.providers.adUmbrella.AdUmbrellaParser;
import io.maslick.apps7.providers.superNetwork.SuperNetworkParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class CsvParseTest {

    @Test
    public void superNetwork() {
        List<Report> list = new SuperNetworkParser().invoke(getCsv("2017-09-16.csv"));
        list.forEach(System.out::println);
        Assert.assertEquals(199, list.size());
    }

    @Test
    public void adUmbrella() {
        List<Report> list = new AdUmbrellaParser().invoke(getCsv("adumbrella-16_9_2017.csv"));
        list.forEach(System.out::println);
        Assert.assertEquals(199, list.size());
    }

    public String getCsv(String fileName) {
        ClassLoader classLoader = CsvParseTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);

        if (resourceAsStream == null)
            throw new IllegalArgumentException("file is corrupt or non-existent");

        Scanner s = new Scanner(resourceAsStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
