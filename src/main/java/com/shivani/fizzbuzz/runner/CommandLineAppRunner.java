package com.shivani.fizzbuzz.runner;

import com.shivani.fizzbuzz.Application;
import com.shivani.fizzbuzz.bean.FizzBuzzType;
import com.shivani.fizzbuzz.service.FizzBuzzService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@ConditionalOnProperty(
        prefix = "command.line.runner",
        value = "enabled"
)
@Component
public class CommandLineAppRunner implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(Application.class);
    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Override
    public void run(String... args) throws Exception {

        FizzBuzzType fizzBuzzType = null;
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter comma seperated values (eg: 1,2,3)");
        String line = scanner.nextLine();

        String[] userInputArray = line.split(",");

        for (String key : userInputArray) {
            // trim the leading and preceding spaces
            key = StringUtils.trim(key);

            if (StringUtils.isEmpty(key)) {
                logger.info("{}: Invalid item", "<empty>");
            } else if (!StringUtils.isNumeric(key)) {
                logger.info("{}: Invalid item", key);
            } else {
                fizzBuzzType = fizzBuzzService.evalNumber(Integer.parseInt(key));
                logger.info("{}: {}", key, fizzBuzzType.toString(fizzBuzzType, Integer.parseInt(key)));
            }
        }
        scanner.close();
    }
}
