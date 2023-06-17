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
208. Implement Trie (Prefix Tree)
228. Summary Ranges
496. Next Greater Element I
503. Next Greater Element II
530. Minimum Absolute Difference in BST
547. Number of Provinces
744. Find Smallest Letter Greater Than Target
1091. Shortest Path in Binary Matrix
1146. Snapshot Array
1161. Maximum Level Sum of a Binary Tree
1187. Make Array Strictly Increasing
1232. Check If It Is a Straight Line
1318. Minimum Flips to Make a OR b Equal to c
1351. Count Negative Numbers in a Sorted Matrix
1502. Can Make Arithmetic Progression From Sequence
1569. Number of Ways to Reorder Array to Get Same BST
2101. Detonate the Maximum Bombs
2716. Minimize String Length
2717. Semi-Ordered Permutation
2733. Neither Minimum nor Maximum
2734. Lexicographically Smallest String After Substring Operation

# Special Topics (3):

## Basic Algorithms
### Sorting algorithm
* Quicksort
* Mergesort

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

