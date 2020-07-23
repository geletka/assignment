package com.creatix.assignment.processor.impl;

import com.creatix.assignment.data.Bigram;
import com.creatix.assignment.processor.IBaseProcessor;

import java.util.HashMap;

public class ResultPrinterProcessor implements IBaseProcessor<Void, HashMap<Bigram, Integer>> {

    @Override
    public Void process(HashMap<Bigram, Integer> histograms) {
        histograms.forEach((bigram, count) -> System.out.println(bigram + " " + count));
        return null;
    }
}
