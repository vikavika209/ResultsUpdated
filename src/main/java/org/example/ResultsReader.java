package org.example;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsReader {
    private final ResultParser resultParser;

    public ResultsReader(ResultParser resultParser) {
        this.resultParser = resultParser;
    }

    public List<ResultsProcessor.Result> readFromFile(Path filePath){
        try{
            return Files.lines(filePath)
                    .map(resultParser::parseResult)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
