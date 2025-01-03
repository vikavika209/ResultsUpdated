package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultParserTest {

    @Test
    void parseResult() {
        ResultParser resultParser = new ResultParser();
        Result result = resultParser.parseResult("Ivanov Ivan,M,10km,55:20");
        Assertions.assertEquals("Ivanov Ivan", result.getPerson().getName());
        Assertions.assertEquals(Gender.MALE, result.getPerson().getGender());
        Assertions.assertEquals(Distance.TEN_KM, result.getDistance());
    }

}