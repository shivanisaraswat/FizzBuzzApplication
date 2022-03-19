package com.shivani.fizzbuzz.handler.impl;

import com.shivani.fizzbuzz.bean.FizzBuzzType;
import com.shivani.fizzbuzz.handler.FizzBuzzEvaluator;
import org.springframework.stereotype.Component;

import static com.shivani.fizzbuzz.service.FizzBuzzConditions.isFizzBuzz;

/**
 * Third handler in chain of responsibility.
 */
@Component
public class FizzBuzzImpl implements FizzBuzzEvaluator {

    @Override
    public FizzBuzzType evaluate(int number) {
        return isFizzBuzz.test(number) ? FizzBuzzType.FizzBuzz : null;
    }
}