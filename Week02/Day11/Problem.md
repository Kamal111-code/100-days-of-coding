# Minimum Absolute Difference

## Problem Statement

Given an array of **distinct integers** `arr`, find **all pairs of elements** that have the **minimum absolute difference** among all possible pairs in the array.

Return the result as a list of pairs in **ascending order (with respect to pairs)**.

---

## Pair Rules

Each returned pair `[a, b]` must satisfy:

- `a` and `b` are elements from `arr`
- `a < b`
- `b - a` equals the **minimum absolute difference** found in the array

---

## Input

- An integer array `arr` of length `n`
- All elements in `arr` are **distinct**

---

## Output

- A list of integer pairs `[[a1, b1], [a2, b2], ...]`
- Pairs are sorted in ascending order

---

## Example

### Input
arr = [4, 2, 1, 3]


### Explanation
After sorting: `[1, 2, 3, 4]`

Absolute differences:
- `2 - 1 = 1`
- `3 - 2 = 1`
- `4 - 3 = 1`

Minimum absolute difference = `1`

### Output
[[1, 2], [2, 3], [3, 4]]


---

## Constraints

- `2 ≤ n ≤ 10^5`
- `-10^9 ≤ arr[i] ≤ 10^9`
- All elements in `arr` are unique

---

## Notes

- Only **adjacent elements after sorting** need to be compared
- Time complexity target: **O(n log n)**
- Extra space should be minimal


