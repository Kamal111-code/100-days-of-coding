# Two Best Non-Overlapping Events

## Problem Statement

You are given a **0-indexed 2D integer array** `events` where:

events[i] = [startTimei, endTimei, valuei]


- The `i`-th event starts at `startTimei` and ends at `endTimei`.
- If you attend this event, you gain `valuei`.

You can attend **at most two non-overlapping events** such that the **sum of their values is maximized**.

### Non-overlapping Rule

- Start time and end time are **inclusive**.
- If one event ends at time `t`, the next event must start at **`t + 1` or later**.
- Events that start exactly when another ends **overlap** and cannot both be attended.

## Objective

Return the **maximum possible sum of values** by attending at most two non-overlapping events.

---

## Example

### Input
events = [[1,3,2],[4,5,2],[2,4,3]]


### Output
4


### Explanation

- Choose event `[1,3,2]` and `[4,5,2]`
- These events do not overlap.
- Total value = `2 + 2 = 4`

---

## Constraints

- `1 <= events.length <= 10^5`
- `1 <= startTimei <= endTimei <= 10^9`
- `1 <= valuei <= 10^6`

---

## Notes

- You may also choose **only one event** or **no events**.
- Efficient solutions typically involve **sorting + binary search** or **prefix maximums**.

## Approach

The goal is to select **at most two non-overlapping events** such that their total value is maximized.  
An event ending at time `t` can only be followed by another event starting at **`t + 1` or later**.

To solve this efficiently, we use **sorting, binary search, and a suffix maximum array**.

---

### 1. Sort Events by Start Time

First, sort all events based on their `startTime`.

Why this is needed:
- It allows us to use **binary search** to quickly find the next event that does not overlap.
- All valid future events will appear to the **right** of the current event in the sorted list.

---

### 2. Build a Suffix Maximum Array

Create an array `suffixMax` where:

suffixMax[i] = maximum value among events from index i to the end


Purpose:
- After finding a valid next event index, we want the **best possible event value** from that point onward.
- This avoids scanning the remaining events and keeps the solution efficient.

---

### 3. Iterate Through Each Event

For each event `i`:

1. Use **binary search** on events after `i` to find the **first event** whose:
startTime > currentEventEndTime

This ensures the two events do not overlap.

2. If such an event is found at index `j`:
- Compute the total value:
  ```
  events[i][2] + suffixMax[j]
  ```

3. Also consider the case where only the current event is chosen:
events[i][2]

4. Keep track of the **maximum sum** across all possibilities.

---

### 4. Final Result

Return the maximum value obtained by:
- Selecting one event, or
- Selecting two non-overlapping events.

---

## Time and Space Complexity

- **Time Complexity:** `O(n log n)`
- Sorting: `O(n log n)`
- Binary search for each event: `O(log n)`

- **Space Complexity:** `O(n)`
- Used for the suffix maximum array
