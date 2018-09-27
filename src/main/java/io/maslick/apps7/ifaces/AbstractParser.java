package io.maslick.apps7.ifaces;

import io.maslick.apps7.pojo.Data;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AbstractParser implements IParser {
    private final String COMMA = ",";

    protected Function<String[], Data> lambda;

    @Override
    public List<Data> invoke(String input) {

        List<Data> list = new ArrayList<>();

        try {
            InputStream inputFS = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            list = br.lines().skip(1).map(line -> lambda.apply(line.split(COMMA)))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return list ;
    }
}
