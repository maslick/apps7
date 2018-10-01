package io.maslick.apps7.ifaces;

import io.maslick.apps7.pojo.Report;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AbstractParser implements IParser {

    private final String COMMA = ",";
    protected Function<String[], Report> lambda;

    protected Date parseDate(String string) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(string);
    }

    @Override
    public List<Report> run(String input) {
        List<Report> list = new ArrayList<>();

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
