package io.maslick.apps7;

import io.maslick.apps7.repo.ReportRepo;
import io.maslick.apps7.service.AdNetwork;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = NONE)
public class IntegrationTest {

    @Autowired
    @Qualifier("superNetwork")
    AdNetwork superNetwork;

    @Autowired
    @Qualifier("adUmbrella")
    AdNetwork adUmbrella;

    @Autowired
    ReportRepo repo;


    @Test
    public void testSuperNetwork() {
        superNetwork.setDate("15.09.2017");
        superNetwork.run();
        Assert.assertEquals(199, repo.findAllByNetwork("superNetwork").size());
    }

    @Test
    public void testAdUmbrella() {
        adUmbrella.setDate("15.09.2017");
        adUmbrella.run();
        Assert.assertEquals(199, repo.findAllByNetwork("adUmbrella").size());
    }

    @Test
    public void testSuperNetworkMultiple() {
        superNetwork.setDate("15.09.2017");
        superNetwork.run();
        superNetwork.run();
        superNetwork.run();
        Assert.assertEquals(199, repo.findAllByNetwork("superNetwork").size());
    }

    @Test
    public void testAdUmbrellaMultiple() {
        adUmbrella.setDate("15.09.2017");
        adUmbrella.run();
        adUmbrella.run();
        adUmbrella.run();
        Assert.assertEquals(199, repo.findAllByNetwork("adUmbrella").size());
    }
}
