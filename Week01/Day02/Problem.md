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

### Example 2
**Input**
prices = [5, 4, 3]
strategy = [1, 1, 0]
k = 2
**Output**
9

**Explanation**

| Strategy          | Profit Calculation                         | Profit |
|-------------------|---------------------------------------------|--------|
| Original           | (1×5) + (1×4) + (0×3)                      | 9      |
| Modify [0,1]       | (0×5) + (1×4) + (0×3)                      | 4      |
| Modify [1,2]       | (1×5) + (0×4) + (1×3)                      | 8      |

Maximum profit is **9**, achieved without modification.

## Constraints
- `2 ≤ prices.length = strategy.length ≤ 10^5`
- `1 ≤ prices[i] ≤ 10^5`
- `-1 ≤ strategy[i] ≤ 1`
- `2 ≤ k ≤ prices.length`
- `k` is even



