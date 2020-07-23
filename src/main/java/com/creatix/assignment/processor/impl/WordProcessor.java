package com.creatix.assignment.processor.impl;

import com.creatix.assignment.processor.IBaseProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordProcessor implements IBaseProcessor<List<String>, String> {

    private static Logger LOG = LoggerFactory.getLogger(WordProcessor.class);

    @Override
    public List<String> process(String fileName) {

        var result = new ArrayList<String>();

        try (var reader = new Scanner(new FileInputStream(fileName))) {

            while (reader.hasNextLine()) {

                var line = reader.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                result.addAll(Stream.of(line).filter(Predicate.not(String::isEmpty)).collect(Collectors.toList()));
            }

        } catch (IOException e) {
            LOG.error("Provided file does not exist");
        }

        return result;
    }
}
