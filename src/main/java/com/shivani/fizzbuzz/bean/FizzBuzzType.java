package com.shivani.fizzbuzz.bean;

public enum FizzBuzzType {
    Number, Buzz, FizzBuzz, Fizz;

    public String toString(FizzBuzzType fizBuzzType, int number) {

        if (fizBuzzType == Number) {
            return "Divided " + number + " by 3" + "\n" + "   Divided " + number + " by 5";
        }
        return super.toString();
    }

}
