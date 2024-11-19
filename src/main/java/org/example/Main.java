package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

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
        var filePath = new ClassPathResource("results.csv").getFile().toPath();
        var results = resultsReader.readFromFile(filePath);
        var resultsProcessor = new ResultsProcessor(results);
        List<Result> fastest = resultsProcessor.getFastest(Distance.TEN_KM, Gender.FEMALE, 2);
        System.out.println(fastest);
    }
}