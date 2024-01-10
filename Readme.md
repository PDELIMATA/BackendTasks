# Java Tasks Project

This Java project consists of three console-based tasks, each addressing a distinct problem. Users can select which task to execute by entering the corresponding task number. Below is an overview of each task:

## Task 1: Distinct Elements and Basic Measurements

### Overview

This Java console application reads a long list of integers from standard input and outputs the distinct elements sorted in ascending order. Additionally, it provides basic measurement information such as the count of elements in the source, number of distinct elements, minimum, and maximum values.

### Execution

1. Run the Java application.
2. Enter a long list of integers separated by spaces.
3. The program will display the distinct elements sorted in ascending order along with measurement information.

### Sample Execution

**Input:**

1 10 20 20 2 5

**Expected Output:**

1 2 5 10 20  
count: 6  
distinct: 5  
min: 1  
max: 20  

## Task 2: Finding Pairs Summing to 13

### Overview

This Java console application reads a long list of integers from standard input and finds pairs within the list that sum up to 13. Each pair in the output is presented with the first number not greater than the second one and sorted in ascending order.

### Execution

1. Run the Java application.
2. Enter a long list of integers separated by spaces.
3. The program will display pairs that sum up to 13, meeting the specified criteria.

### Sample Execution

**Input:**

1 2 10 7 5 3 6 6 13 0

**Expected Output:**

0 13  
3 10  
6 7  
6 7


## Task 3: Counting Separated Graphs

### Overview

This Java console application reads input that defines connections between vertices in a graph. It calculates the number of separated graphs based on this input.

### Execution

1. Run the Java application.
2. Enter the number of connections `n`.
3. Enter `n` pairs of positive integers representing connections between vertices.
4. The program will display the number of separated graphs based on the input.

### Sample Execution

**Input:**

3  
4 3  
1 4  
5 6

**Expected Output:**

2