package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ResultsProcessorConfig.class);
        ResultsReader resultsReader = applicationContext.getBean(ResultsReader.class);
        var results = resultsReader.readFromFile(Path.of("C:\\Users\\Пользователь_Asus\\IdeaProjects\\Results\\src\\main\\resources\\results.csv"));
        var resultsProcessor = new ResultsProcessor(results);
        List<ResultsProcessor.Result> fastest = resultsProcessor.getFastest(Distance.TEN_KM, ResultParser.Gender.FEMALE, 1);
        System.out.println(fastest);
    }

    public enum Distance {
        FIVE_KM("5 km"),
        TEN_KM("10 km");

        private final String code;

        Distance(String code) {
            this.code = code;
        }

        public static Distance of(String code){
            return Stream.of(values())
                    .filter(d -> Objects.equals(d.code, code))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown distance: " + code));
        }
    }
}