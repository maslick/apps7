package io.maslick.apps7.ifaces;

import io.maslick.apps7.pojo.Data;

public interface ILineParser {
    Data invoke(String[] line);
}
