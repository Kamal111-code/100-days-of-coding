# Maximum Profit with One Strategy Modification

## Problem Statement
You are given two integer arrays `prices` and `strategy` of equal length `n`.

- `prices[i]` represents the stock price on the `i`-th day.
- `strategy[i]` represents the trading action on the `i`-th day:
  - `-1` → buy one unit
  - `0` → hold
  - `1` → sell one unit

You are also given an **even integer `k`**. You may perform **at most one modification** to the `strategy` array.

### Modification Rules
- Select exactly `k` consecutive elements in `strategy`
- Set the **first `k / 2` elements** to `0` (hold)
- Set the **last `k / 2` elements** to `1` (sell)

The **profit** is defined as **sum** of strategy[i] * prices[i] across all days.
profit = Σ (strategy[i] * prices[i])


There are **no constraints on budget or stock ownership**, so all buy and sell actions are always valid.

Return the **maximum possible profit** after applying at most one modification.
### Example 1
**Input**
prices = [4,2,8], strategy = [-1,0,1], k = 2

**Output**
10

**Explanation**

| Strategy          | Profit Calculation                         | Profit |
|-------------------|---------------------------------------------|--------|
| Original           | (-1×4) + (0×2) + (1×8)                     | 4      |
| Modify [0,1]       | (0×4) + (1×2) + (1×8)                      | 10     |
| Modify [1,2]       | (-1×4) + (0×2) + (1×8)                     | 4      |

Maximum profit is **10**.

---

## Approach

### Key Observation
The profit contribution of each day is:

profit[i] = strategy[i] × prices[i]

Since only **one contiguous subarray of length `k`** can be modified, we focus on calculating the **profit change (delta)** caused by applying the modification to that subarray.

---

### Step 1: Compute Original Profit
- Calculate the total profit using the original strategy.
- Also store each day's individual contribution.

---

### Step 2: Evaluate the Effect of a Modification
For any window of size `k`:
- The **first `k/2` days** are forced to `hold (0)`  
  → their contribution becomes `0`
- The **last `k/2` days** are forced to `sell (1)`  
  → their contribution becomes `prices[i]`

So for each window, we compute:




