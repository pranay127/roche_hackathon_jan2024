package com.hackathon.Fizzbuzz_;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hackathon.Fizzbuzz_.controller.FizzBuzzController;
import com.hackathon.Fizzbuzz_.model.Statistics;
import com.hackathon.Fizzbuzz_.service.FizzBuzzService;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@SpringBootTest
class FizzbuzzApplicationTests {

 private MockMvc mockMvc;

 @Mock
 private FizzBuzzService fizzBuzzService;

 @InjectMocks
 private FizzBuzzController fizzBuzzController;

 @BeforeEach
 void setUp() {
     MockitoAnnotations.openMocks(this);
     mockMvc = MockMvcBuilders.standaloneSetup(fizzBuzzController).build();
 }

 @Test
 void testGetFizzBuzz() throws Exception {
     when(fizzBuzzService.generateFizzBuzz(3, 5, 15, "Fizz", "Buzz"))
             .thenReturn(Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
                     "11", "Fizz", "13", "14", "FizzBuzz"));

     mockMvc.perform(MockMvcRequestBuilders.get("/fizzbuzz")
             .param("multipleOf3", "3")
             .param("multipleOf5", "5")
             .param("limit", "15")
             .param("replacementForMultipleOf3", "Fizz")
             .param("replacementForMultipleOf5", "Buzz")
             .contentType(MediaType.APPLICATION_JSON))
             .andExpect(MockMvcResultMatchers.status().isOk())
             .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
             .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(15));

     verify(fizzBuzzService, times(1)).generateFizzBuzz(3, 5, 15, "Fizz", "Buzz");
     verifyNoMoreInteractions(fizzBuzzService);
 }

 @Test
 void testGetStatistics() throws Exception {
     when(fizzBuzzService.getStatistics())
             .thenReturn(new Statistics("3_5_15_Fizz_Buzz", 5));

     mockMvc.perform(MockMvcRequestBuilders.get("/statistics")
             .contentType(MediaType.APPLICATION_JSON))
             .andExpect(MockMvcResultMatchers.status().isOk())
             .andExpect(MockMvcResultMatchers.jsonPath("$.mostUsedRequest").value("3_5_15_Fizz_Buzz"))
             .andExpect(MockMvcResultMatchers.jsonPath("$.mostUsedRequestCount").value(5));

     verify(fizzBuzzService, times(1)).getStatistics();
     verifyNoMoreInteractions(fizzBuzzService);
 }
}
