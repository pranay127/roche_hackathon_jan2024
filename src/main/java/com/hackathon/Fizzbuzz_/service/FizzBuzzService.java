package com.hackathon.Fizzbuzz_.service;


import org.springframework.stereotype.Service;

import com.hackathon.Fizzbuzz_.model.Statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FizzBuzzService {

    private Map<String, Integer> requestStatistics = new HashMap<>();
    private String mostUsedRequest;
    private int mostUsedRequestCount;

    public List<String> generateFizzBuzz(int int1, int int2, int limit, String str1, String str2) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= limit; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % int1 == 0) {
                sb.append(str1);
            }
            if (i % int2 == 0) {
                sb.append(str2);
            }
            if (sb.length() == 0) {
                sb.append(i);
            }

            String requestKey = int1 + "_" + int2 + "_" + limit + "_" + str1 + "_" + str2;
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
}
