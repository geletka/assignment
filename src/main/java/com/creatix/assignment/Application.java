package com.creatix.assignment;

import com.creatix.assignment.data.Bigram;
import com.creatix.assignment.processor.IBaseProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(Application.class);

    @Autowired
    private IBaseProcessor<List<String>, String> wordProcessor;

    @Autowired
    private IBaseProcessor<List<Bigram>, List<String>> bigramProcessor;

    @Autowired
    private IBaseProcessor<HashMap<Bigram, Integer>, List<Bigram>> histogramProcessor;

    @Autowired
    private IBaseProcessor<Void, HashMap<Bigram, Integer>> resultPrinterProcessor;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        if (args != null && args.length == 1) {
            LOG.info("Start to process file with name " + args[0]);

            // 1. get all words ignoring case sensitivity and punctuation
            var words = wordProcessor.process(args[0]);
            LOG.info("Found " + words.size() + " words to process");

            // 2. transform words to bigrams
            var bigrams = bigramProcessor.process(words);
            LOG.info("Found " + bigrams.size() + " bigrams to process");

            // 3. transform bigrams to histograms
            var histograms = histogramProcessor.process(bigrams);
            LOG.info("Found  " + histograms.size() + " histograms");

            // 4. print formatted result
            resultPrinterProcessor.process(histograms);

        } else {
            LOG.error("Please provide exactly one file for input");
        }
    }
}
