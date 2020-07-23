package com.creatix.assignment.configuration;

import com.creatix.assignment.data.Bigram;
import com.creatix.assignment.processor.impl.BigramProcessor;
import com.creatix.assignment.processor.impl.HistogramProcessor;
import com.creatix.assignment.processor.IBaseProcessor;
import com.creatix.assignment.processor.impl.ResultPrinterProcessor;
import com.creatix.assignment.processor.impl.WordProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;

@Configuration
public class AppConfiguration {

    @Bean
    public IBaseProcessor<List<String>, String> wordProcessor() {
        return new WordProcessor();
    }

    @Bean
    public IBaseProcessor<List<Bigram>, List<String>> bigramProcessor() {
        return new BigramProcessor();
    }

    @Bean
    public IBaseProcessor<HashMap<Bigram, Integer>, List<Bigram>> histogramProcessor() {
        return new HistogramProcessor();
    }

    @Bean
    public IBaseProcessor<Void, HashMap<Bigram, Integer>> resultPrinterProcessor() {
        return new ResultPrinterProcessor();
    }

}
