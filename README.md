# roche_hackathon_jan2024
# FizzBuzz Service

## Overview

This is a Spring Boot service that provides FizzBuzz sequences and tracks statistics on the most frequently requested FizzBuzz parameters.

## Build Instructions

### Prerequisites
- Java JDK 8 or higher
- Maven

### Build and Run
1. Clone the repository:
   ```bash
   git clone https://github.com/pranay127/roche_hackathon_jan2024.git
   
2. Build Project
   ```bash
   mvn clean install

   java -jar target/fizzbuzz-service-1.0.0.jar
   
   OR
   Import as maven project in eclipse and run

The service will start on http://localhost:8080

APIS:
1.Generate FizzBuzz Sequence:

   Url:
   http://localhost:8080/fizzbuzz?multipleOf3=3&multipleOf5=5&limit=15&replacementForMultipleOf3=fizz&replacementForMultipleOf5=buzz

   Parameters:
   multipleOf3 (integer): Multiples of this number will be replaced with str1.
   multipleOf5 (integer): Multiples of this number will be replaced with str2.
   limit (integer): The limit for the FizzBuzz sequence.
   replacementForMultipleOf3 (string): The replacement for multiples of int1.
   replacementForMultipleOf5 (string): The replacement for multiples of int2.

   Output
   ```bash
   [
       "1",
       "2",
       "fizz",
       "4",
       "buzz"
   ]
2.Get Statistics

   Url:
   http://localhost:8080/statistics
   Output:
   ```bash 
   {
       "mostUsedRequest": "3_5_5_fizz_buzz",
       "mostUsedRequestCount": 5
   }





 
