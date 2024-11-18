package org.example;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsProcessor {
    private final List<Result> results;

    public ResultsProcessor(List<Result> results) {
        this.results = results;
    }

    public List<Result> getFastest(Distance distance, Gender gender, int n){
        return results.stream()
                .filter(result -> result.getDistance().equals(distance))
                .filter(result -> result.getPerson().getGender().equals(gender))
                .sorted(Comparator.comparing(Result::getTime))
                .limit(n)
                .collect(Collectors.toList());
    }


}
