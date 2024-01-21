# Roche Hackathon 2024
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

### APIS
1. Generate FizzBuzz Sequence:

   Url:
   http://localhost:8080/fizzbuzz?num1=3&num2=5&limit=5&replacementForMultipleOfNum1=fizz&replacementForMultipleOfNum2=buzz
   
   Parameters:
   
   num1 (integer): Multiples of this number will be replaced with replacementForMultipleOfNum1.<br />
   num2 (integer): Multiples of this number will be replaced with replacementForMultipleOfNum2.<br />
   limit (integer): The limit for the FizzBuzz sequence.<br />
   replacementForMultipleOfNum1 (string): The replacement for multiples of num1.<br />
   replacementForMultipleOfNum2 (string): The replacement for multiples of num2.

   Output:
   ```json
   [
       "1",
       "2",
       "fizz",
       "4",
       "buzz"
   ]

3. Get Statistics

   Url:
   http://localhost:8080/statistics

   Output:
   ```json
   {
       "mostUsedRequest": "3_5_5_fizz_buzz",
       "mostUsedRequestCount": 5
   }





 
