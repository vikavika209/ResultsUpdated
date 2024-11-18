package org.example;

import java.time.Duration;
import java.util.Objects;
import java.util.stream.Stream;

public class ResultParser {
    public ResultsProcessor.Result parseResult(String line){
        var resultParts = line.split(",");
        var name = resultParts[0];
        var gender = resultParts[1];
        var distance = resultParts[2];
        var time = parseTime(resultParts[3]);

        Person person = new Person(name, Gender.of(gender));
        return new ResultsProcessor.Result(person, Main.Distance.of(distance), time);
    }

    private Duration parseTime(String time){
        var timeParts = time.split(":");
        var totalSeconds = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
        return Duration.ofSeconds(totalSeconds);
    }

    public enum Gender {
        MALE("M"),
        FEMALE("F");


        private final String code;

        Gender(String code) {
            this.code = code;
        }

        public static Gender of(String code){
            return Stream.of(values())
                    .filter(g -> Objects.equals(g.code, code))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown gender: " + code));
        }
    }

    public static class Person {
        String name;
        Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public Person() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }
    }
}
