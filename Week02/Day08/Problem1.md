#  Best Time to Buy and Sell Stock

## Problem Statement

You are given an array `prices` where `prices[i]` represents the price of a stock on the `i`th day.

You want to maximize your profit by choosing:
- **one day to buy** the stock, and
- **a different future day to sell** the stock.

Return the **maximum profit** you can achieve.  
If no profit is possible, return `0`.

---

## Example

**Input**
prices = [7,1,5,3,6,4]


**Output**
5


**Explanation**

Buy on day 2 at price `1` and sell on day 5 at price `6`.  
Profit = `6 - 1 = 5`

---

## Approach (Single Pass – Greedy)

The key idea is to **track the minimum price so far** and calculate the profit if we sell on the current day.

### Key Idea
- Maintain a variable `minPrice` to store the lowest price encountered so far.
- For each day:
  - Calculate profit = `currentPrice - minPrice`
  - Update `maxProfit` if this profit is higher.
  - Update `minPrice` if a lower price is found.

This ensures we always **buy before we sell**.

---

## Steps
1. Initialize `minPrice` with a very large value.
2. Initialize `maxProfit` as `0`.
3. Traverse the array:
   - Update `minPrice` if the current price is smaller.
   - Calculate potential profit and update `maxProfit`.
4. Return `maxProfit`.

---

## Code (Java)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}
