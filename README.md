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
Java solutions to leetcode problems

1. Two Sum
2. Add Two Numbers
3. Longest Substring Without Repeating Characters
7. Reverse Integer
11. Container With Most Water
12. Integer to Roman
13. Roman to Integer
14. Longest Common Prefix
17. Letter Combinations of a Phone Number
19. Remove Nth Node From End of List
22. Generate Parentheses
26. Remove Duplicates from Sorted Array
27. Remove Element
28. Find the Index of the First Occurrence in a String
30. Substring with Concatenation of All Words
33. Search in Rotated Sorted Array
36. Valid Sudoku
39. Template.Combination Sum
42. Trapping Rain Water
45. Jump Game II
46. Permutations
48. Rotate Image
49. Group Anagrams
50. Pow(x, n)
51. N-Queens
52. N-Queens II
55. Jump Game
56. Merge Intervals
58. Length of Last Word
61. Rotate List
62. Unique Paths
63. Unique Paths II
68. Text Justification
69. Sqrt(x)
74. Search a 2D Matrix
77. Combinations
78. Search in Rotated Sorted Array II
80. Remove Duplicates from Sorted Array II
82. Remove Duplicates from Sorted List II
88. Merge Sorted Array
92. Reverse Linked List II
94. Binary Tree Inorder Traversal
95. Unique Binary Search Trees II
97. Interleaving String
98. Validate Binary Search Tree
100. Same Tree
102. Binary Tree Level Order Traversal
103. Binary Tree Zigzag Level Order Traversal
104. Maximum Depth of Binary Tree
105. Construct Binary Tree from Preorder and Inorder Traversal
111. Minimum Depth of Binary Tree
112. Path Sum
117. Populating Next Right Pointers in Each Node II
121. Best Time to Buy and Sell Stock
122. Best Time to Buy and Sell Stock II
124. Binary Tree Maximum Path Sum
125. Valid Palindrome
128. Longest Consecutive Sequence
129. Sum Root to Leaf Numbers
134. Gas Station
136. Single Number
137. Single Number II
138. Copy List with Random Pointer
139. Word Break
150. Evaluate Reverse Polish Notation
151. Reverse Words in a String
162. Find Peak Element
167. Two Sum II - Input Array Is Sorted
168. Excel Sheet Column Title
169. Majority Element
173. Binary Search Tree Iterator
183. Customers Who Never Order
199. Binary Tree Right Side View
200. Number of Islands
201. Bitwise AND of Numbers Range
205. Isomorphic Strings
207. Course Schedule
208. Implement Template.Trie (Prefix Tree)
209. Minimum Size Subarray Sum
214. Shortest Palindrome
215. Kth Largest Element in an Array
225. Implement Stack using Queues
226. Invert Binary Tree
228. Summary Ranges
230. Kth Smallest Element in a BST
238. Product of Array Except Self
239. Sliding Window Maximum
240. Search a 2D Matrix II
242. Valid Anagram
289. Game of Life
260. Single Number III
274. H-Index
279. Perfect Squares
290. Word Pattern
303. Range Sum Query - Immutable
304. Range Sum Query 2D - Immutable
322. Coin Change
373. Find K Pairs with Smallest Sums
378. Kth Smallest Element in a Sorted Matrix
380. Insert Delete GetRandom O(1)
383. Ransom Note
403. Frog Jump
445. Add Two Numbers II
452. Minimum Number of Arrows to Burst Balloons
493. Reverse Pairs
496. Next Greater Element I
503. Next Greater Element II
530. Minimum Absolute Difference in BST
547. Number of Provinces
556. Next Greater Element III
646. Maximum Length of Pair Chain
729. My Calendar I
744. Find Smallest Letter Greater Than Target
767. Reorganize String
802. Find Eventual Safe States
852. Peak Index in a Mountain Array
858. Mirror Reflection
859. Buddy Strings
863. All Nodes Distance K in Binary Tree
898. Bitwise ORs of Subarrays
956. Tallest Billboard
1091. Shortest Path in Binary Matrix
1109. Corporate Flight Bookings
1146. Snapshot Array
1161. Maximum Level Sum of a Binary Tree
1171. Remove Zero Sum Consecutive Nodes from Linked List
1187. Make Array Strictly Increasing
1218. Longest Arithmetic Subsequence of Given Difference
1232. Check If It Is a Straight Line
1318. Minimum Flips to Make a OR b Equal to c
1351. Count Negative Numbers in a Sorted Matrix
1353. Maximum Number of Events That Can Be Attended
1493. Longest Subarray of 1's After Deleting One Element
1502. Can Make Arithmetic Progression From Sequence
1569. Number of Ways to Reorder Array to Get Same BST
1575. Count All Possible Routes
1601. Maximum Number of Achievable Transfer Requests
1607. Sellers With No Sales
1711. Count Good Meals
1732. Find the Highest Altitude
1802. Maximum Value at a Given Index in a Bounded Array
1870. Minimum Speed to Arrive on Time
2013. Detect Squares
2024. Maximize the Confusion of an Exam
2090. K Radius Subarray Averages
2101. Detonate the Maximum Bombs
2305. Fair Distribution of Cookies
2328. Number of Increasing Paths in a Grid
2352. Equal Row and Column Pairs
2369. Check if There is a Valid Partition For The Array
2448. Minimum Cost to Make Array Equal
2462. Total Cost to Hire K Workers
2536. Increment Submatrices by One
2551. Put Marbles in Bags
2616. Minimize the Maximum Difference of Pairs
2716. Minimize String Length
2717. Semi-Ordered Permutation
2733. Neither Minimum nor Maximum
2734. Lexicographically Smallest String After Substring Operation
2735. Collecting Chocolates
2748. Number of Beautiful Pairs
2749. Minimum Operations to Make the Integer Zero
2750. Ways to Split Array Into Good Subarrays
2806. Account Balance After Rounded Purchase
2807. Insert Greatest Common Divisors in Linked List
2808. Minimum Seconds to Equalize a Circular Array
2810. Faulty Keyboard
2811. Check if it is Possible to Split Array
2833. Furthest Point From Origin
2834. Find the Minimum Possible Sum of a Beautiful Array
2923. Find Champion I
2924. Find Champion II
2925. Maximum Score After Applying Operations on a Tree

MySQL solutions to Leetcode database problems  
0. SQL
175. Combine Two Tables
176. Second Highest Salary
180. Consecutive Numbers
196. Delete Duplicate Emails
197. Rising Temperature
550. Game Play Analysis IV
570. Managers with at Least 5 Direct Reports
577. Employee Bonus
584. Find Customer Referee
595. Big Countries
596. Classes More Than 5 Students
610. Triangle Judgement
619. Biggest Single Number
620. Not Boring Movies
1045. Customers Who Bought All Products
1068. Product Sales Analysis I
1070. Product Sales Analysis III
1075. Project Employees I
1112. Highest Grade For Each Student
1141. User Activity for the Past 30 Days I
1148. Article Views I
1164. Product Price at a Given Date
1174. Immediate Food Delivery II
1193. Monthly Transactions I
1204. Last Person to Fit in the Bus
1211. Queries Quality and Percentage
1251. Average Selling Price
1280. Students and Examinations
1327. List the Products Ordered in a Period
1378. Replace Employee ID With The Unique Identifier
1398. Customers Who Bought Products A and B but Not C
1484. Group Sold Products By The Date
1517. Find Users With Valid E-Mails
1527. Patients With a Condition
1581. Customer Who Visited but Did Not Make Any Transactions
1633. Percentage of Users Attended a Contest
1661. Average Time of Process per Machine
1667. Fix Names in a Table
1683. Invalid Tweets
1729. Find Followers Count
1731. The Number of Employees Which Report to Each Employee
1789. Primary Department for Each Employee
1757. Recyclable and Low Fat Products
1821. Find Customers With Positive Revenue this Year
1873. Calculate Special Bonus
1907. Count Salary Categories
1934. Confirmation Rate
2356. Number of Unique Subjects Taught by Each Teacher


# Special Topics (4):

## Basic Algorithms
### Sorting algorithm
* Quicksort
* Mergesort
* **786 第k个数（快速选择算法）**
* 215 Kth Largest Element in an Array
* **788 逆序对的数量**
* 493 Reverse Pairs
### Binary Search Algorithm
* BinarySearch
* 162 Find Peak Element
* 789 数的范围
* **790 数的三次方根**
### Prefix Sum and Difference
* **795 前缀和**
* 303 Range Sum Query - Immutable
* **796 子矩阵的和**
* 304 Range Sum Query 2D - Immutable
* **797 差分**
* 1109 Corporate Flight Bookings
* **798 差分矩阵**
* 2536 Increment Submatrices by One
### Two-Pointer Technique
* 799 最长连续不重复子序列
* 800 数组元素的目标和
* 2024 Maximize the Confusion of an Exam
* 11 Container With Most Water
### Knuth-Morris-Pratt Algorithm
* KMP
* 28 Find the Index of the First Occurrence in a String
* 831 KMP字符串
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
* 830 单调栈
* 496 Next Greater Element I
* 503 Next Greater Element II
### Queue
* 829 模拟队列
### Monotonic Queue
* 154 滑动窗口
* 239 Sliding Window Maximum
### Circular Queue

### Trie
* Trie
### Disjoint-Set Data Structure (Union–Find set)
* DisjointSet
* 547 Number of Provinces
### Heap & Priority Queue


## Number Theory
### Combinatorics
* Combination
* Permutation
* 1569 Number of Ways to Reorder Array to Get Same BST
### Binary Exponentiation
* 50 Pow(x, n)


## Graph
### Compute the Connectivity Matrix (Warshall Algorithm)
* 2101 Detonate the Maximum Bombs
### Topological Sort
* 207 Course Schedule
### Dijkstra Algorithm


## Advanced Algorithms
# Dynamic Programming
* 279 Perfect Squares
* 1187 Make Array Strictly Increasing

