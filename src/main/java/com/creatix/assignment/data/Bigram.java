package com.creatix.assignment.data;

import java.util.Objects;

public class Bigram {

    private String firstWord;
    private String secondWord;

    public Bigram(String firstWord, String secondWord) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }

    @Override
    public String toString() {
        return firstWord + ' ' + secondWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bigram other = (Bigram) o;
        return this.firstWord.equals(other.firstWord) && this.secondWord.equals(other.secondWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstWord, secondWord);
    }
}
