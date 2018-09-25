package io.maslick.apps7;

import io.maslick.apps7.ifaces.IPersister;
import io.maslick.apps7.pojo.Data;

import java.util.List;

public class Persister implements IPersister {
    @Override
    public void invoke(List<Data> data) {
        System.out.println("Persisting report...");
    }
}
