package io.maslick.apps7.ifaces;

import io.maslick.apps7.pojo.Report;
import java.util.List;

public interface IPersister {
    void invoke(List<Report> data);
}
