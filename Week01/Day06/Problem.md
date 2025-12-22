# Delete Columns to Make Sorted (Row-wise)

## Problem Statement
You are given an array of `n` strings `strs`, where all strings have the same length.

You may choose any set of column indices and delete those columns from **every** string.

After deletions, the remaining characters in **each individual string** must be in **non-decreasing lexicographical order**.

Your task is to return the **minimum number of columns** that need to be deleted to satisfy this condition.

> Note: The rows are checked **independently**.  
> The array of strings itself does **not** need to be lexicographically sorted.

---

## Example

### Input
strs = ["babca", "bbazb"]


### Explanation
Deleting columns `{0, 1, 4}` results in:
["bc", "az"]

- `"bc"` is lexicographically sorted
- `"az"` is lexicographically sorted

The minimum number of deletions required is `3`.

### Output
3

## Approach

### Key Idea
Instead of directly deciding which columns to delete, we determine the **maximum number of columns that can be kept** such that **every row remains lexicographically sorted**.

The minimum number of deletions is then:
total_columns − maximum_columns_kept


---

### Dynamic Programming Definition
Let:
dp[i] = length of the longest valid non-decreasing column sequence ending at column i


Each column represents a position across all rows.

---

### Transition
For every pair of columns `j < i`:
- Column `i` can follow column `j` **only if**, for every row:
strs[row][j] <= strs[row][i]

- If valid:
dp[i] = max(dp[i], dp[j] + 1)

---

### Algorithm Steps
1. Initialize `dp[i] = 1` for all columns
2. For each column `i`:
 - Check all previous columns `j < i`
 - Validate ordering across all rows
 - Update `dp[i]` accordingly
3. Track the maximum value in `dp` (length of LIS)
4. Return:
columns − LIS

---

## Time & Space Complexity
- **Time Complexity:** `O(cols² × rows)`
- **Space Complexity:** `O(cols)`
