package com.shivani.fizzbuzz.service;

import com.shivani.fizzbuzz.bean.FizzBuzzType;
import com.shivani.fizzbuzz.handler.impl.BuzzImpl;
import com.shivani.fizzbuzz.handler.impl.FizzBuzzImpl;
import com.shivani.fizzbuzz.handler.impl.FizzImpl;
import com.shivani.fizzbuzz.handler.impl.NumberImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

    @Autowired
    FizzImpl fizzHandler;

    @Autowired
    BuzzImpl buzzHandler;

    @Autowired
    FizzBuzzImpl fizzBuzzHandler;

    @Autowired
    NumberImpl numberHandler;

    public FizzBuzzType evalNumber(int number) {

        FizzBuzzType fizzBuzzType = null;

        if ((fizzBuzzType = fizzHandler.evaluate(number)) != null) {
            return fizzBuzzType;
        } else if ((fizzBuzzType = buzzHandler.evaluate(number)) != null) {
            return fizzBuzzType;
        } else if ((fizzBuzzType = fizzBuzzHandler.evaluate(number)) != null) {
            return fizzBuzzType;
        } else if ((fizzBuzzType = numberHandler.evaluate(number)) != null) {
            return fizzBuzzType;
        }

        return fizzBuzzType;
    }
}
