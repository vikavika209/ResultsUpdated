package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ResultsProcessorTest {
    ResultParser resultParser = new ResultParser();
    List<Result> results = new LinkedList<>();

    @Test
    void getFastest() {
        Result result1 = resultParser.parseResult("Иван Иванов,M,10km,55:20");
        Result result2 = resultParser.parseResult("Петров Иванов,M,5km,25:20");
        results.add(result1);
        results.add(result2);
        ResultsProcessor resultsProcessor = new ResultsProcessor(results);
        List<Result> res = resultsProcessor.getFastest(Distance.FIVE_KM, Gender.MALE, 1);
        Assertions.assertTrue(res.contains(result2));

    }
}