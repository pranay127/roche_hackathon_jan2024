package com.hackathon.Fizzbuzz_.service;

import com.hackathon.Fizzbuzz_.model.Statistics;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FizzBuzzService {

    private Map<String, Integer> requestStatistics = new HashMap<>();
    private String mostUsedRequest;
    private int mostUsedRequestCount;

    public List<String> generateFizzBuzz(int num1, int num2, int limit, String replacementForMultipleOfNum1, String replacementForMultipleOfNum2) {
        try {
            validateInputParameters(num1, num2, limit, replacementForMultipleOfNum1, replacementForMultipleOfNum2);
        } catch (IllegalArgumentException e) {
            return List.of("Error: " + e.getMessage());
        }

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= limit; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % num1 == 0) {
                sb.append(replacementForMultipleOfNum1);
            }
            if (i % num2 == 0) {
                sb.append(replacementForMultipleOfNum2);
            }
            if (sb.length() == 0) {
                sb.append(i);
            }

            String requestKey = num1 + "_" + num2 + "_" + limit + "_" + replacementForMultipleOfNum1 + "_" + replacementForMultipleOfNum2;
            requestStatistics.put(requestKey, requestStatistics.getOrDefault(requestKey, 0) + 1);

            if (requestStatistics.get(requestKey) > mostUsedRequestCount) {
                mostUsedRequest = requestKey;
                mostUsedRequestCount = requestStatistics.get(requestKey);
            }

            result.add(sb.toString());
        }

        return result;
    }

    public Statistics getStatistics() {
        return new Statistics(mostUsedRequest, mostUsedRequestCount);
    }

    private void validateInputParameters(int num1, int num2, int limit, String replacementForMultipleOfNum1, String replacementForMultipleOfNum2) {
        if (num1 <= 0) {
            throw new IllegalArgumentException("num1 must be greater than zero.");
        }

        if (num2 <= 0) {
            throw new IllegalArgumentException("num2 must be greater than zero.");
        }

        if (limit <= 0) {
            throw new IllegalArgumentException("limit must be greater than zero.");
        }

        if (replacementForMultipleOfNum1 == null || replacementForMultipleOfNum2 == null) {
            throw new IllegalArgumentException("replacementForMultipleOfNum1 and replacementForMultipleOfNum2 cannot be null.");
        }
    }
}
