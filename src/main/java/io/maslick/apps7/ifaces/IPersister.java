package io.maslick.apps7.ifaces;

import io.maslick.apps7.pojo.Report;
import java.util.List;

public interface IPersister {
    void save(String network, List<Report> data);
}
