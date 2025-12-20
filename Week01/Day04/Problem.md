# Delete Columns to Make Sorted

## Problem Statement
You are given an array of `n` strings `strs`, where all strings have the same length.

The strings can be arranged in a grid such that each string represents one row.  
You want to **delete columns** that are **not sorted lexicographically** from top to bottom.

A column is considered sorted if, for every row `i`:
strs[i][col] <= strs[i + 1][col]


Return the **number of columns that need to be deleted**.

---

## Example

### Input
strs = ["abc", "bce", "cae"]

### Output
1

## Approach

### Observation
Each column is independent of the others.  
A column is considered sorted if characters from top to bottom are in **non-decreasing lexicographical order**.

---

### Steps
1. Let `n` be the number of strings and `m` be the length of each string
2. Iterate through each column `j` from `0` to `m - 1`
3. For each column, compare characters row by row:
   - If `strs[i][j] < strs[i - 1][j]`, the column is not sorted
4. Increment the deletion count and move to the next column
5. Return the total count of unsorted columns

---

### Optimization
The check for a column stops immediately after the first invalid comparison, avoiding unnecessary work.
