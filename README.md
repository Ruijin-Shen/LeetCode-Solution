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
208. Implement Trie (Prefix Tree)
228. Summary Ranges
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
1502. Can Make Arithmetic Progression From Sequence
1569. Number of Ways to Reorder Array to Get Same BST
1732. Find the Highest Altitude
1802. Maximum Value at a Given Index in a Bounded Array
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
* **799 最长连续不重复子序列**
### Bitwise Operation
* 求n的第k位数字（k从0开始） n >> k & 1
* lowbit(n) = n & -n;


## Number Theory
### Combinatorics
* Combination
* 1569 Number of Ways to Reorder Array to Get Same BST

## Data Structure
### Disjoint-Set Data Structure (Union–Find set)
* DisjointSet
* 547 Number of Provinces


## Graph
### Compute the Connectivity Matrix (Warshall Algorithm)
* 2101 Detonate the Maximum Bombs

## Dynamic Programming
* 1187 Make Array Strictly Increasing

