package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultsReaderTest {
    ResultParser resultParser = new ResultParser();
    ResultsReader resultsReader = new ResultsReader(resultParser);

    @Test
    void readFromFile() throws IOException {
        var filePath = new ClassPathResource("results.csv").getFile().toPath();
        var results = resultsReader.readFromFile(filePath);
        List<Result> res = resultsReader.readFromFile(filePath);
        Result result = resultParser.parseResult("Васильева Яна,F,5km,21:30");
        Assertions.assertTrue(res.contains(result));
    }
}