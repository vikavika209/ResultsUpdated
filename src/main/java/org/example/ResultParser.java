package org.example;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ResultParser {

    public ResultParser() {
    }

    public Result parseResult(String line){
        var resultParts = line.split(",");
        var name = resultParts[0];
        var gender = resultParts[1];
        var distance = resultParts[2];
        var time = parseTime(resultParts[3]);

        Person person = new Person(name, Gender.of(gender));
        return new Result(person, Distance.of(distance), time);
    }

    private Duration parseTime(String time){
        var timeParts = time.split(":");
        var totalSeconds = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
        return Duration.ofSeconds(totalSeconds);
    }
}
