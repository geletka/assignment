package com.creatix.assignment;

import com.creatix.assignment.data.Bigram;
import com.creatix.assignment.processor.IBaseProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ApplicationTests {

    @Autowired
    private IBaseProcessor<List<String>, String> wordProcessor;

    @Autowired
    private IBaseProcessor<List<Bigram>, List<String>> bigramProcessor;

    @Autowired
    private IBaseProcessor<HashMap<Bigram, Integer>, List<Bigram>> histogramProcessor;

    @Test
    void testWordProcessor() {
        Assertions.assertEquals(9,
                wordProcessor.process("src/test/resources/input1").size());
    }

    @Test
    void testBigramProcessor() {
        Assertions.assertEquals(5,
                bigramProcessor.process(Arrays.asList("test", "test1", "test2", "test1", "test2", "test1")).size());
    }

    @Test
    void testHistogramProcessor() {
        Assertions.assertEquals(3,
                histogramProcessor.process(Arrays.asList(
                        new Bigram("test", "test1"),
                        new Bigram("test1", "test2"),
                        new Bigram("test2", "test1"),
                        new Bigram("test1", "test2"),
                        new Bigram("test2", "test1"))).size()
        );
    }

    @Test
    void testApp() {
        var histograms = histogramProcessor.process(bigramProcessor.process(wordProcessor.process("src/test/resources/input2")));
        Assertions.assertEquals(146, histograms.size());
        Assertions.assertEquals(histograms.get(new Bigram("the", "quick")), 4);
        Assertions.assertEquals(histograms.get(new Bigram("bigram", "parsing")), 3);
        Assertions.assertEquals(histograms.get(new Bigram("the", "bigram")), 3);
        Assertions.assertEquals(histograms.get(new Bigram("counting", "code")), 2);
        Assertions.assertEquals(histograms.get(new Bigram("and", "have")), 1);

    }
}
