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

    public List<String> generateFizzBuzz(int multipleOf3, int multipleOf5, int limit, String replacementForMultipleOf3, String replacementForMultipleOf5) {
        try {
            validateInputParameters(multipleOf3, multipleOf5, limit, replacementForMultipleOf3, replacementForMultipleOf5);
        } catch (IllegalArgumentException e) {
            return List.of("Error: " + e.getMessage());
        }

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= limit; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % multipleOf3 == 0) {
                sb.append(replacementForMultipleOf3);
            }
            if (i % multipleOf5 == 0) {
                sb.append(replacementForMultipleOf5);
            }
            if (sb.length() == 0) {
                sb.append(i);
            }

            String requestKey = multipleOf3 + "_" + multipleOf5 + "_" + limit + "_" + replacementForMultipleOf3 + "_" + replacementForMultipleOf5;
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

    private void validateInputParameters(int multipleOf3, int multipleOf5, int limit, String replacementForMultipleOf3, String replacementForMultipleOf5) {
        if (multipleOf3 <= 0) {
            throw new IllegalArgumentException("multipleOf3 must be greater than zero.");
        }

        if (multipleOf5 <= 0) {
            throw new IllegalArgumentException("multipleOf5 must be greater than zero.");
        }

        if (limit <= 0) {
            throw new IllegalArgumentException("limit must be greater than zero.");
        }

        if (replacementForMultipleOf3 == null || replacementForMultipleOf5 == null) {
            throw new IllegalArgumentException("replacementForMultipleOf3 and replacementForMultipleOf5 cannot be null.");
        }
    }
}
