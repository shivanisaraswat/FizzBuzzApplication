package com.shivani.fizzbuzz.service;

import java.util.function.IntPredicate;

public class FizzBuzzConditions {

    public static final IntPredicate isFizz = number -> number % 3 == 0 && number % 5 != 0;
    public static final IntPredicate isBuzz = number -> number % 3 != 0 && number % 5 == 0;
    public static final IntPredicate isFizzBuzz = number -> number % 3 == 0 && number % 5 == 0;
    public static final IntPredicate isNotFizzBuzz = number -> number % 3 != 0 && number % 5 != 0;

    private FizzBuzzConditions() {
    }

}
