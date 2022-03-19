package com.shivani.fizzbuzz.handler.impl;

import com.shivani.fizzbuzz.bean.FizzBuzzType;
import com.shivani.fizzbuzz.handler.FizzBuzzEvaluator;
import org.springframework.stereotype.Component;

import static com.shivani.fizzbuzz.service.FizzBuzzConditions.isNotFizzBuzz;

/**
 * Last handler in chain of responsibility.
 */
@Component
public class NumberImpl implements FizzBuzzEvaluator {

    @Override
    public FizzBuzzType evaluate(int number) {
        return isNotFizzBuzz.test(number) ? FizzBuzzType.Number : null;
    }

}
