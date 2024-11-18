package org.example;

import java.time.Duration;

public class Result {
    Person person;
    Distance distance;
    Duration time;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Result() {
    }

    public Result(Person person, Distance distance, Duration time) {
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