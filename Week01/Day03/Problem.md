# Find All People With Secret

## Problem Statement
You are given an integer `n` representing `n` people numbered from `0` to `n - 1`.

You are also given a 2D array `meetings`, where:
meetings[i] = [xi, yi, timei]

indicates that person `xi` and person `yi` have a meeting at time `timei`.

A person can attend multiple meetings at the same time.

Initially:
- Person `0` knows a secret
- At time `0`, person `0` shares the secret with `firstPerson`

### Secret Sharing Rules
- If a person knows the secret at time `timei`, they share it with the other person in the meeting
- The sharing is **instantaneous**, meaning a person can receive and share the secret within the same time frame

Return a list of all people who know the secret after all meetings have taken place.  
The answer may be returned in any order.

---

## Example

### Input
n = 6
meetings = [[1,2,5], [2,3,8], [1,5,10]]
firstPerson = 1


### Output
[0, 1, 2, 3, 5]


### Explanation
- At time `0`, person `0` shares the secret with person `1`
- At time `5`, person `1` shares the secret with person `2`
- At time `8`, person `2` shares the secret with person `3`
- At time `10`, person `1` shares the secret with person `5`

---

## Approach

### Key Insight
Secret sharing is **time-dependent**.  
Only meetings occurring at the **same time** can propagate the secret instantly among their participants.

Meetings at different times must be processed independently.

---

### Step 1: Sort Meetings by Time
- Sort all meetings by `timei`
- This allows processing meetings in chronological order

---

### Step 2: Process Meetings Grouped by Time
- For each unique time value:
  - Collect all meetings happening at that time
  - Build a temporary **graph (adjacency list)** using only those participants
  - Track all people involved in the current time group

---

### Step 3: BFS to Spread the Secret
- Initialize a queue with all people in the current time group who already know the secret
- Perform **BFS** on the temporary graph:
  - If a person with the secret meets another person, the secret is shared
  - Newly informed people can immediately spread the secret within the same time frame

This works because secret sharing is instantaneous within the same time.

---

### Step 4: Persist Knowledge Across Time
- After finishing BFS for the current time group:
  - Only the `knowsSecret` array is updated
  - The temporary graph is discarded
- This ensures secrets do **not leak across different times incorrectly**

---

### Step 5: Collect the Result
- After all meetings are processed, return all people who know the secret

---

## Time & Space Complexity
- **Time Complexity:** `O(m log m)` due to sorting meetings (`m` = number of meetings)
- **Space Complexity:** `O(n + m)` for adjacency lists and tracking secret holders


