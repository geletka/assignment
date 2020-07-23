package com.creatix.assignment.processor.impl;

import com.creatix.assignment.data.Bigram;
import com.creatix.assignment.processor.IBaseProcessor;

import java.util.ArrayList;
import java.util.List;

public class BigramProcessor implements IBaseProcessor<List<Bigram>, List<String>> {

    @Override
    public List<Bigram> process(List<String> words) {
        var result = new ArrayList<Bigram>();

        for (int i = 0; i < words.size() - 1; i++) {
            result.add(new Bigram(words.get(i), words.get(i + 1)));
        }

        return result;
    }
}
