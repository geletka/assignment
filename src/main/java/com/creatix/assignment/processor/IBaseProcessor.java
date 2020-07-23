package com.creatix.assignment.processor;

public interface IBaseProcessor<R, T> {

    R process(T request);
}