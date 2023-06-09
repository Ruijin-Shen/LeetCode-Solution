<style type="text/css">
    h1 { counter-reset: h2counter; }
    h2 { counter-reset: h3counter; }
    h3 { counter-reset: h4counter; }
    h4 { counter-reset: h5counter; }
    h5 { counter-reset: h6counter; }
    h6 { }
    h2:before {
      counter-increment: h2counter;
      content: counter(h2counter) ".\0000a0\0000a0";
    }
    h3:before {
      counter-increment: h3counter;
      content: counter(h2counter) "."
                counter(h3counter) ".\0000a0\0000a0";
    }
    h4:before {
      counter-increment: h4counter;
      content: counter(h2counter) "."
                counter(h3counter) "."
                counter(h4counter) ".\0000a0\0000a0";
    }
    h5:before {
      counter-increment: h5counter;
      content: counter(h2counter) "."
                counter(h3counter) "."
                counter(h4counter) "."
                counter(h5counter) ".\0000a0\0000a0";
    }
    h6:before {
      counter-increment: h6counter;
      content: counter(h2counter) "."
                counter(h3counter) "."
                counter(h4counter) "."
                counter(h5counter) "."
                counter(h6counter) ".\0000a0\0000a0";
    }
</style>


# LeetCode-Solution
Java solutions for leetcode problems

1. Two Sum
2. Add Two Numbers
3. Longest Substring Without Repeating Characters
13. Roman to Integer
22. Generate Parentheses
136. Single Number
137. Single Number II
150. Evaluate Reverse Polish Notation
199. Binary Tree Right Side View
207. Course Schedule
208. Implement Trie (Prefix Tree)
209. Minimum Size Subarray Sum
228. Summary Ranges
260. Single Number III
373. Find K Pairs with Smallest Sums
493. Reverse Pairs
496. Next Greater Element I
503. Next Greater Element II
530. Minimum Absolute Difference in BST
547. Number of Provinces
744. Find Smallest Letter Greater Than Target
859. Buddy Strings
956. Tallest Billboard
1091. Shortest Path in Binary Matrix
1146. Snapshot Array
1161. Maximum Level Sum of a Binary Tree
1187. Make Array Strictly Increasing
1232. Check If It Is a Straight Line
1318. Minimum Flips to Make a OR b Equal to c
1351. Count Negative Numbers in a Sorted Matrix
1493. Longest Subarray of 1's After Deleting One Element
1502. Can Make Arithmetic Progression From Sequence
1569. Number of Ways to Reorder Array to Get Same BST
1575. Count All Possible Routes
1601. Maximum Number of Achievable Transfer Requests
1732. Find the Highest Altitude
1802. Maximum Value at a Given Index in a Bounded Array
2024. Maximize the Confusion of an Exam
2090. K Radius Subarray Averages
2101. Detonate the Maximum Bombs
2305. Fair Distribution of Cookies
2352. Equal Row and Column Pairs
2448. Minimum Cost to Make Array Equal
2462. Total Cost to Hire K Workers
2716. Minimize String Length
2717. Semi-Ordered Permutation
2733. Neither Minimum nor Maximum
2734. Lexicographically Smallest String After Substring Operation
2735. Collecting Chocolates
2748. Number of Beautiful Pairs
2749. Minimum Operations to Make the Integer Zero
2750. Ways to Split Array Into Good Subarrays

# Special Topics (4):

## Basic Algorithms
### Sorting algorithm
* Quicksort
* Mergesort
* 786 第k个数（快速选择算法）
* 788 逆序对的数量
### Binary Search Algorithm
* BinarySearch
* 789 数的范围
* **790 数的三次方根**
### Prefix Sum and Difference
* **795 前缀和**
* **796 子矩阵的和**
* **797 差分**
* **798 差分矩阵**
### Two-Pointer Technique
* 799 最长连续不重复子序列
* 800 数组元素的目标和
* 2024 Maximize the Confusion of an Exam
### Bitwise Operation
* 求n的第k位数字（k从0开始） ```n >> k & 1```
* ```lowbit(n) = n & -n;```
* 136 Single Number
* 137 Single Number II
* 260 Single Number III


## Data Structure
### Stack
* 828 模拟栈
* 150 Evaluate Reverse Polish Notation
### Monotonic Stack
* 496 Next Greater Element I
* 503 Next Greater Element II
### Queue
* 829 模拟队列
### Priority Queue
### Circular Queue
### Disjoint-Set Data Structure (Union–Find set)
* DisjointSet
* 547 Number of Provinces


## Number Theory
### Combinatorics
* Combination
* 1569 Number of Ways to Reorder Array to Get Same BST


## Graph
### Compute the Connectivity Matrix (Warshall Algorithm)
* 2101 Detonate the Maximum Bombs
### Topological Sort
* 207 Course Schedule

## Dynamic Programming
* 1187 Make Array Strictly Increasing

