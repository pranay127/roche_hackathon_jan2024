package com.hackathon.Fizzbuzz_.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.Fizzbuzz_.model.Statistics;
import com.hackathon.Fizzbuzz_.service.FizzBuzzService;

import java.util.List;

@RestController
public class FizzBuzzController {

    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzController.class);

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping("/fizzbuzz")
    public List<String> getFizzBuzz(
    		@RequestParam(name = "multipleOf3") int int1,
            @RequestParam(name = "multipleOf5") int int2,
            @RequestParam(name = "limit") int limit,
            @RequestParam(name = "replacementForMultipleOf3") String str1,
            @RequestParam(name = "replacementForMultipleOf5") String str2) {
        logger.info("Received FizzBuzz request with parameters: int1={}, int2={}, limit={}, str1={}, str2={}",
                int1, int2, limit, str1, str2);
        List<String> result = fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);
        logger.info("FizzBuzz request processed successfully.");
        return result;
    }

    @GetMapping("/statistics")
    public Statistics getStatistics() {
        logger.info("Received request for statistics.");
        Statistics statistics = fizzBuzzService.getStatistics();
        logger.info("Statistics request processed successfully.");
        return statistics;
    }
}
