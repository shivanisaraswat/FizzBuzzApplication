package com.shivani.fizzbuzz.service;

import com.shivani.fizzbuzz.bean.FizzBuzzType;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.shivani.fizzbuzz.service.FizzBuzzConditions.*;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzServiceTests {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    public void testNumbersDivisibleBy3Given_ShouldReturnFizzList() {
        // given
        List<Integer> divisibleBy3Only = getNumbers().filter(isFizz).boxed().collect(Collectors.toList());
        // when
        List<FizzBuzzType> fizzTypes = divisibleBy3Only.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        Assertions.assertSame(divisibleBy3Only.size(), fizzTypes.size());
        assertThat(fizzTypes, everyItem(is(FizzBuzzType.Fizz)));
    }

    @Test
    public void testNumbersDivisibleBy5Given_ShouldReturnBuzzList() {
        // given
        List<Integer> divisibleBy5Only = getNumbers().filter(isBuzz).boxed().collect(Collectors.toList());
        // when
        List<FizzBuzzType> buzzTypes = divisibleBy5Only.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        Assertions.assertSame(divisibleBy5Only.size(), buzzTypes.size());
        assertThat(buzzTypes, everyItem(is(FizzBuzzType.Buzz)));
    }

    @Test
    public void testNumbersDivisibleBy3And5Given_ShouldReturnFizzBuzzList() {
        // given
        List<Integer> divisibleBy3And5 = getNumbers().filter(isFizzBuzz).boxed().collect(Collectors.toList());
        // when
        List<FizzBuzzType> fizzBuzzTypes = divisibleBy3And5.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        Assertions.assertSame(divisibleBy3And5.size(), fizzBuzzTypes.size());
        assertThat(fizzBuzzTypes, everyItem(is(FizzBuzzType.FizzBuzz)));
    }

    @Test
    public void testNumbersDivisibleBy3And5Given_ShouldReturnNumber() {
        // given
        List<Integer> notFizzBuzz = getNumbers().filter(isNotFizzBuzz).boxed().collect(Collectors.toList());
        // when
        List<FizzBuzzType> notFizzBuzzTypes = notFizzBuzz.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        Assertions.assertSame(notFizzBuzz.size(), notFizzBuzzTypes.size());
        assertThat(notFizzBuzzTypes, everyItem(is(FizzBuzzType.Number)));
    }

    private IntStream getNumbers() {
        Supplier<IntStream> streamSupplier
                = () -> Stream.iterate(1, i -> i + 1).limit(100)
                .flatMapToInt(IntStream::of);
        return streamSupplier.get();
    }
}

