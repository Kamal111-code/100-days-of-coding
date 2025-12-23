# Longest Substring Without Repeating Characters

## Problem Statement
Given a string `s`, find the length of the longest substring that contains no repeating characters.

## Examples
**Input:** `s = "abcabcbb"`  
**Output:** `3`  
**Explanation:** The longest substring is `"abc"`.

**Input:** `s = "bbbbb"`  
**Output:** `1`  
**Explanation:** The longest substring is `"b"`.

**Input:** `s = "pwwkew"`  
**Output:** `3`  
**Explanation:** The longest substring is `"wke"`.

## Constraints
- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols, and spaces

---

## Approach

### 1. Brute Force (Not Optimal)
- Check all possible substrings
- Use a set or array to track character frequency
- Stop when a duplicate is found

**Time Complexity:** `O(n^2)`  
**Space Complexity:** `O(n)`

---

### 2. Sliding Window (Optimal)
- Use two pointers `left` and `right`
- Expand the window by moving `right`
- Use a HashSet/HashMap to track characters
- When a duplicate is found, shrink the window from the left
- Track the maximum window size

**Time Complexity:** `O(n)`  
**Space Complexity:** `O(n)`

---

## Key Learning
Using the sliding window technique avoids rechecking characters and reduces time complexity from `O(n^2)` to `O(n)`.
