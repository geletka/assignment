package com.creatix.assignment.processor.impl;

import com.creatix.assignment.data.Bigram;
import com.creatix.assignment.processor.IBaseProcessor;

import java.util.HashMap;
import java.util.List;

public class HistogramProcessor implements IBaseProcessor<HashMap<Bigram, Integer>, List<Bigram>> {

    @Override
    public HashMap<Bigram, Integer> process(List<Bigram> bigrams) {
        var result = new HashMap<Bigram, Integer>();

        bigrams.forEach(it -> {
            var count = result.getOrDefault(it, 0);
            if (count == 0) {
                result.put(it, 1);
            } else {
                result.put(it, count + 1);
            }
        });

        return result;
    }
}
