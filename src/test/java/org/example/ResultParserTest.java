package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultParserTest {

    @Test
    void parseResult() {
        ResultParser resultParser = new ResultParser();
        ResultsProcessor.Result result = resultParser.parseResult("Иван Иванов, М, 10 км, 55:20");
        Assertions.assertEquals("Иван Иванов", result.getPerson().getName());
        Assertions.assertEquals(ResultParser.Gender.MALE, result.getPerson().getGender());
        Assertions.assertEquals(Main.Distance.TEN_KM, result.getDistance());
    }
}