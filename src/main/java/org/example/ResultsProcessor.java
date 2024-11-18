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

    public List<Result> getFastest(Main.Distance distance, ResultParser.Gender gender, int n){
        return results.stream()
                .filter(result -> result.getDistance().equals(distance))
                .filter(result -> result.getPerson().getGender().equals(gender))
                .sorted(Comparator.comparing(Result::getTime))
                .limit(n)
                .collect(Collectors.toList());
    }

    public static class Result {
        ResultParser.Person person;
        Main.Distance distance;
        Duration time;

        public ResultParser.Person getPerson() {
            return person;
        }

        public void setPerson(ResultParser.Person person) {
            this.person = person;
        }

        public Duration getTime() {
            return time;
        }

        public void setTime(Duration time) {
            this.time = time;
        }

        public Main.Distance getDistance() {
            return distance;
        }

        public void setDistance(Main.Distance distance) {
            this.distance = distance;
        }

        public Result() {
        }

        public Result(ResultParser.Person person, Main.Distance distance, Duration time) {
            this.person = person;
            this.distance = distance;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "person=" + person +
                    ", distance=" + distance +
                    ", time=" + time +
                    '}';
        }
    }
}
