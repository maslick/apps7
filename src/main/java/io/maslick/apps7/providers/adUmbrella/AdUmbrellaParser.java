package io.maslick.apps7.providers.adUmbrella;

import io.maslick.apps7.pojo.Data;
import io.maslick.apps7.ifaces.IParser;

import java.util.ArrayList;
import java.util.List;

public class AdUmbrellaParser implements IParser {

    @Override
    public List<Data> invoke(String string) {
        System.out.println("Parsing AdUmbrella...");
        return new ArrayList<>();
    }
}
