📅 01/08/2025 — [118. Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)  
**Level**: Easy  
**Language**: Java  
**Approach**: Dynamic Programming (Build row by row)  

- Goal: Generate the first `numRows` of Pascal’s Triangle.  
- Each row starts and ends with `1`.  
- Middle elements are formed by summing the two numbers directly above it (from the previous row).  

**Steps**:  
1. Initialize the triangle as a list of lists.  
2. Add the first row `[1]`.  
3. For each new row:  
   - Start with `1`.  
   - Fill middle values by summing adjacent elements from the previous row.  
   - End with `1`.  
4. Append the row to the triangle.  

**Time Complexity**: O(N²) — where N is `numRows`.  
**Space Complexity**: O(N²) — storing all rows of the triangle.  

💡 *Classic DP problem: each element is derived from the two numbers above it. The beauty lies in its simplicity and symmetry.*  
---

📅 02/08/2025 — [2561. Rearranging Fruits](https://leetcode.com/problems/rearranging-fruits/)  
**Level**: Hard  
**Language**: Java  
**Approach**: Frequency Map + Greedy + Sorting  

- Goal: Make `basket1` and `basket2` identical with minimum cost by swapping elements.  
- A valid solution exists only if the frequency difference for each fruit is even (otherwise return `-1`).  
- Use a frequency map to calculate the net imbalance of each fruit between baskets.  
- Collect the extra fruits into a list `merge`.  
- Sort `merge` and for the cheaper half, compute the cost of fixing imbalance.  
- Cost is the minimum between:  
  - Swapping directly with the other basket (`merge.get(i)`), or  
  - Using the smallest fruit value (`2 * minValue`) as a "proxy swap".  

**Steps**:  
1. Count frequency difference of each fruit between `basket1` and `basket2`.  
2. If any difference is odd → return `-1` (impossible).  
3. Build a list of excess fruits to be swapped.  
4. Sort the list to prioritize cheaper swaps.  
5. For each fruit in the cheaper half of the list, add the minimum of `fruit` vs `2 * minValue` to result.  

**Time Complexity**: O(N log N) — due to sorting the extra fruits.  
**Space Complexity**: O(N) — for frequency map and merge list.  

💡 *The trick lies in considering both direct swaps and proxy swaps through the global minimum fruit for lower cost.*  
---

📅 03/08/2025 — [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)  
**Level**: Medium  
**Language**: Java  
**Approach**: Sliding Window + HashMap  

- Goal: Find the longest subarray where there are at most 2 distinct fruit types.  
- This is equivalent to finding the longest subarray with at most 2 distinct integers.  
- Use a sliding window with a HashMap to track fruit counts.  
- Shrink the window from the left whenever more than 2 distinct fruits appear.  

**Steps**:  
1. Initialize `left = 0`, `max = 1`, and an empty map.  
2. Expand the right pointer and add fruits to the map.  
3. If map size exceeds 2, shrink the window by moving `left` until size ≤ 2.  
4. Update `max` with the largest window size found.  
5. Return `max`.  

**Time Complexity**: O(N) — each element is processed at most twice (left & right pointers).  
**Space Complexity**: O(1) — since the map holds at most 2 fruit types.  

💡 *Classic sliding window problem where the key is controlling the number of distinct items in the window.*  
---

📅 04/08/2025 — [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)  
**Level**: Medium  
**Language**: Java  
**Approach**: Sliding Window + HashMap  

- Goal: Find the length of the longest subarray containing at most 2 distinct fruit types.  
- Use a sliding window to dynamically maintain a valid range.  
- HashMap keeps track of the frequency of each fruit type.  
- Shrink the window from the left whenever the basket has more than 2 fruit types.  

**Steps**:  
1. Start with `left = 0`, `max = 1`, and an empty HashMap.  
2. Expand the window by moving `right` and update fruit counts in the map.  
3. If more than 2 distinct fruits exist, shrink the window by moving `left`.  
4. Update `max` with the size of the largest valid window.  
5. Return `max`.  

**Time Complexity**: O(N) — both pointers move at most N steps.  
**Space Complexity**: O(1) — map holds at most 2 fruit types.  

💡 *Same logic as Day 3 — repeated to strengthen sliding window mastery.*  
---

📅 05/08/2025 — [3477. Fruits Into Baskets II (Unplaced Fruits)](https://leetcode.com/problems/number-of-unplaced-fruits/)  
**Level**: Easy  
**Language**: Java  
**Approach**: Greedy Placement  

- Goal: Determine how many fruits cannot be placed into baskets.  
- Each fruit can only go into the **first basket** whose capacity is ≥ fruit size.  
- Once a basket is used, it becomes unavailable (`capacity = 0`).  
- If no valid basket is found, the fruit is counted as **unplaced**.  

**Steps**:  
1. Initialize `count = 0`.  
2. For each fruit:  
   - Scan baskets sequentially.  
   - If basket capacity ≥ fruit, place fruit and mark basket as used (`0`).  
   - Otherwise, if no basket fits, increment `count`.  
3. Return total `count`.  

**Time Complexity**: O(N × M) — where N = number of fruits, M = number of baskets (worst case scan per fruit).  
**Space Complexity**: O(1) — in-place update of baskets array.  

💡 *A straightforward greedy approach: always attempt to place each fruit in the first suitable basket; leftover fruits are the answer.*  
---

📅 06/08/2025 — [3489. Fruits Into Baskets III (Unplaced Fruits, Optimized)](https://leetcode.com/problems/number-of-unplaced-fruits-ii/)  
**Level**: Medium  
**Language**: Java  
**Approach**: Square Root Decomposition + Greedy  

- Goal: Place fruits into baskets (each basket can hold only one fruit if capacity ≥ fruit size) and count how many fruits remain unplaced.  
- Instead of scanning all baskets for every fruit (O(N × M)), divide baskets into **blocks** using √N decomposition.  
- Maintain `maxV[sec]` = maximum capacity in each block to quickly skip irrelevant sections.  
- Only when a block might fit the fruit, scan inside it to find the exact basket.  
- Update both `baskets[]` and `maxV[]` after each placement.  

**Steps**:  
1. Partition baskets into blocks of size `√N`.  
2. Precompute the maximum basket capacity in each block.  
3. For each fruit:  
   - Check blocks sequentially.  
   - If block max < fruit → skip block.  
   - Else scan inside block, place fruit in first valid basket, update `maxV`.  
4. If no basket fits, increment `count`.  

**Time Complexity**: O(N√N) worst case — block scanning reduces unnecessary checks.  
**Space Complexity**: O(√N) — extra array `maxV` for block maximums.  

💡 *Improves upon the naive greedy by skipping over irrelevant blocks using sqrt decomposition, making it faster for large input sizes.*  
---

📅 07/08/2025 — [3363. Max Collected Fruits](https://leetcode.com/problems/max-collected-fruits/)  
**Level**: Hard  
**Language**: Java  
**Approach**: Dynamic Programming + Matrix Transpose  

- Goal: Collect maximum fruits along specific matrix paths.  
- First, collect the diagonal fruits (`fruits[i][i]`).  
- Then compute maximum path sum using DP on the upper-right part of the matrix.  
- Transpose the matrix and repeat DP on the new structure to capture symmetric paths.  
- Add up all collected fruits for the final result.  

**Steps**:  
1. Initialize `ans` with diagonal fruits sum.  
2. Define a DP function:  
   - `prev[]` keeps best path values from previous row.  
   - For each position `(i, j)`, compute the best from left, right, or same column of previous row.  
   - Add current fruit value.  
3. Run DP once on original matrix.  
4. Transpose the matrix (swap `fruits[i][j]` with `fruits[j][i]`).  
5. Run DP again and add to `ans`.  
6. Return `ans`.  

**Time Complexity**: O(N²) — traversing the matrix twice with DP.  
**Space Complexity**: O(N) — for DP arrays (`prev`, `curr`).  

💡 *Key insight: solve once on the matrix, then transpose and repeat to capture both directional contributions.*  
---

📅 08/08/2025 — [808. Soup Servings](https://leetcode.com/problems/soup-servings/)  
**Level**: Medium  
**Language**: Java  
**Approach**: Dynamic Programming (Probability States)  

- Goal: Given two types of soup (A and B) with `n ml` each, find the probability that soup A becomes empty first (plus half the probability that both A and B become empty at the same time).  
- Reduce the problem by dividing soup into units of 25 ml (since all operations serve multiples of 25).  
- Define `dp[i][j]` = probability when A has `i` units and B has `j` units left.  
- Transitions consider 4 serving operations:  
  1. Serve 100 ml A, 0 ml B  
  2. Serve 75 ml A, 25 ml B  
  3. Serve 50 ml A, 50 ml B  
  4. Serve 25 ml A, 75 ml B  
- Base cases:  
  - `dp[0][0] = 0.5` (both empty at same time).  
  - `dp[0][j] = 1.0` (A empty first).  
  - `dp[i][0] = 0.0` (B empty first).  
- Stop early if probability approaches 1.  

**Steps**:  
1. Convert `n` to `m = ceil(n / 25)`.  
2. Initialize DP maps with base cases.  
3. Iteratively compute probabilities using transition formula.  
4. Stop if diagonal probability (`dp[k][k]`) is very close to 1.  
5. Return `dp[m][m]`.  

**Time Complexity**: O(N² / 625) — since problem is scaled down by 25.  
**Space Complexity**: O(N² / 625) — storing DP states.  

💡 *The trick is scaling the problem into 25 ml units and using DP to compute probabilities efficiently.*  
---

📅 09/08/2025 — [231. Power of Two](https://leetcode.com/problems/power-of-two/)  
**Level**: Easy  
**Language**: Java  
**Approach**: Bit Manipulation  

- Goal: Check if a given integer `n` is a power of two.  
- Key property: A power of two has exactly **one set bit** in its binary representation.  
- Trick: `(n & (n - 1)) == 0` is true **only when `n` is a power of two** (and `n > 0`).  
  - Example:  
    - `n = 8 → (1000 & 0111) = 0000 → true`  
    - `n = 12 → (1100 & 1011) = 1000 → false`  

**Steps**:  
1. Return `false` if `n < 1`.  
2. Use the condition `(n & (n - 1)) == 0`.  
3. Return the result.  

**Time Complexity**: O(1) — single bitwise operation.  
**Space Complexity**: O(1) — constant extra space.  

💡 *The trick is using bitwise AND to eliminate the lowest set bit and check if only one exists.*  
---

📅 10/08/2025 — [869. Reordered Power of 2](https://leetcode.com/problems/reordered-power-of-2/)  
**Level**: Medium  
**Language**: Java  
**Approach**: Digit Frequency Matching  

- Goal: Check if the digits of `n` can be reordered to form a power of 2.  
- Count the frequency of digits in `n`.  
- Iterate through all powers of 2 up to `2^30`.  
- For each power, compare its digit frequency with `n`.  
- If any match, return `true`; otherwise, return `false`.  

**Steps**:  
1. Create a digit count array for `n`.  
2. Loop over powers of 2 from `2^0` to `2^30`.  
3. For each, count its digits and compare with `n`.  
4. If equal → valid reorder found.  
5. Else return false.  

**Time Complexity**: O(31 * d) ≈ O(1) — only 31 checks with at most 10 digits.  
**Space Complexity**: O(1) — fixed digit count arrays.  

💡 *The trick is digit-count comparison instead of generating all permutations.*  
---

📅 11/08/2025 — [2438. Range Product Queries of Powers](https://leetcode.com/problems/range-product-queries-of-powers/)  
**Level**: Medium  
**Language**: Java  
**Approach**: Binary Decomposition + Modular Multiplication  

- Goal: Find the product of powers of two (from the binary form of `n`) within each query range `[l, r]`, modulo 10⁹+7.  
- Convert `n` into its power-of-two components based on set bits.  
- For each query, multiply elements in the given range and take modulo at each step.  
- Return all query results in an array.  

**Steps**:  
1. Decompose `n` into powers of two and store in a list.  
2. For each query `[start, end]`, multiply powers in that range.  
3. Apply modulo after every multiplication.  
4. Store and return results for all queries.  

**Time Complexity**: O(Q × K) — K is the number of set bits in `n`.  
**Space Complexity**: O(K) — storing powers of two.  

💡 *Binary decomposition avoids recalculating powers, making queries efficient.*
---

📅 12/08/2025 — [2787. Ways to Express an Integer as Sum of Powers](https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/)  
**Level**: Medium  
**Language**: Java  
**Approach**: Dynamic Programming (Subset Sum with Powers)  

- Goal: Count the number of ways to represent `n` as the sum of unique integers raised to the power `x`, modulo 10⁹+7.  
- Treat the problem like a **subset-sum** variant where each number `i` contributes `i^x`.  
- Use DP to decide whether to include or exclude each power in the sum.  
- Return the total ways to form `n`.  

**Steps**:  
1. Initialize a DP table `dp[i][j]` = number of ways to form sum `j` using powers up to `i^x`.  
2. Base case: `dp[0][0] = 1` (one way to form 0).  
3. For each number `i` from 1 to `n`, compute `val = i^x`.  
4. For each sum `j`, carry over `dp[i-1][j]` (exclude) and add `dp[i-1][j - val]` (include if possible).  
5. Take modulo at every addition and return `dp[n][n]`.  

**Time Complexity**: O(n²) — nested loops over numbers and possible sums.  
**Space Complexity**: O(n²) — DP table of size (n+1) × (n+1).  

💡 *This is a power-based variation of the classic subset-sum dynamic programming problem.*
---

📅 13/08/2025 — [326. Power of Three](https://leetcode.com/problems/power-of-three/)  
**Level**: Easy  
**Language**: Java  
**Approach**: Mathematical Divisibility  

- Goal: Check if a given integer `n` is a power of 3.  
- Use the largest power of 3 within 32-bit integer range (`3¹⁹ = 1162261467`).  
- A number `n` is a power of 3 if it divides `1162261467` evenly.  

**Steps**:  
1. Return `false` if `n ≤ 0`.  
2. Otherwise, check if `1162261467 % n == 0`.  
3. If true → `n` is a power of 3; else false.  

**Time Complexity**: O(1) — single modulus operation.  
**Space Complexity**: O(1) — constant space.  

💡 *Leverages the fact that all powers of 3 divide the largest power within integer range.*
---

📅 14/08/2025 — [2264. Largest 3-Same-Digit Number in String](https://leetcode.com/problems/largest-3-same-digit-number-in-string/)  
**Level**: Easy  
**Language**: Java  
**Approach**: String Matching (Fixed-Length Window)  

- Goal: Find the largest substring of length 3 in `num` that consists of the same digit (e.g., "777").  
- Check from highest possible same-digit numbers (`"999"` → `"000"`) for existence in the string.  
- Return the first match found.  

**Steps**:  
1. Prepare a list of possible 3-digit repeating patterns from "999" down to "000".  
2. For each pattern, check if it exists in the given string `num`.  
3. Use a sliding window of size 3 to compare substrings.  
4. Return the first matching pattern (the largest).  
5. If none match, return an empty string.  

**Time Complexity**: O(10 × n) ≈ O(n) — check each pattern across the string once.  
**Space Complexity**: O(1) — constant auxiliary space.  

💡 *Iterating from highest to lowest repeating digit ensures the first match is the largest valid substring.*
---

📅 15/08/2025 — [342. Power of Four](https://leetcode.com/problems/power-of-four/)  
**Level**: Easy  
**Language**: Java  
**Approach**: Bit Manipulation  

- Goal: Check if a given integer `n` is a power of 4.  
- First ensure `n` is a power of 2 (`n & (n - 1)) == 0`).  
- Then confirm the single set bit lies in an even position using bitmask `0x55555555`.  

**Steps**:  
1. Return `false` if `n ≤ 0`.  
2. Check if `n` is a power of 2 → `(n & (n - 1)) == 0`.  
3. Verify the bit is in an even position → `(n & 0x55555555) == n`.  
4. Return `true` only if both conditions hold.  

**Time Complexity**: O(1) — constant-time bitwise operations.  
**Space Complexity**: O(1) — no extra space used.  

💡 *The mask `0x55555555` filters bits at even positions, distinguishing powers of 4 from powers of 2.*
---

📅 16/10/2025 — [1323. Maximum 69 Number](https://leetcode.com/problems/maximum-69-number/)  
**Level**: Easy  
**Language**: Java  
**Approach**: Digit Manipulation  

- Goal: Maximize a number composed of digits 6 and 9 by changing **at most one 6 to 9**.  
- Reverse the number to process digits from left to right.  
- Change the **first encountered 6** to 9 and reconstruct the result.  

**Steps**:  
1. Reverse the input number to handle digits from the most significant side.  
2. Traverse the reversed digits one by one.  
3. When the first `6` is found, change it to `9`.  
4. Build the new number by appending digits in order.  
5. Return the updated number.  

**Time Complexity**: O(d) — where *d* is the number of digits.  
**Space Complexity**: O(1) — uses constant extra space.  

💡 *Changing the first 6 (from left) to 9 yields the maximum possible number.*
---

📅 17/10/2025 — [837. New 21 Game](https://leetcode.com/problems/new-21-game/)  
**Level**: Medium  
**Language**: Java  
**Approach**: Dynamic Programming (Sliding Window Probability)  

- Goal: Find the probability that Alice’s total score is ≤ `n` in the "21 game", where she stops drawing once reaching at least `k`.  
- Use DP where `dp[i]` represents the probability of getting exactly `i` points.  
- Maintain a running window sum `s` of the last `maxPts` DP states for efficient computation.  

**Steps**:  
1. Initialize `dp[0] = 1` (starting point with probability 1).  
2. For each `i` from 1 to `n`, compute `dp[i] = s / maxPts`.  
3. Update the sliding window:  
   - Add `dp[i]` to `s` if `i < k` (still allowed to draw).  
   - Subtract `dp[i - maxPts]` when it moves out of the window.  
4. After filling DP, sum all probabilities `dp[i]` for `i ∈ [k, n]`.  
5. Return the total probability.  

**Time Complexity**: O(n) — each state is processed once with O(1) updates.  
**Space Complexity**: O(n) — DP array of size `n + 1`.  

💡 *Sliding window optimization avoids recomputing sums, keeping the DP efficient for large `n`.*

---

📅 18/10/2025 — [679. 24 Game](https://leetcode.com/problems/24-game/)  
**Level**: Hard  
**Language**: Java  
**Approach**: Backtracking with Floating-Point Precision  

- Goal: Determine if you can reach 24 using four numbers with any combination of `+`, `-`, `*`, `/` and parentheses.  
- Use DFS to recursively combine numbers two at a time with all possible operations.  
- Check all operation orders (non-commutative included) and use a tolerance for floating-point comparisons.  

**Steps**:  
1. Convert input integers to a list of doubles for accurate division handling.  
2. At each recursion level, pick two numbers `a` and `b`.  
3. Generate all results of applying `+`, `-`, `*`, `/` on them (skip invalid divisions).  
4. Recurse with the new reduced list of results.  
5. If at any stage a single number ≈ 24 (within `1e-6`), return true.  

**Time Complexity**: O(4ⁿ × n²) — exploring all pair and operator combinations.  
**Space Complexity**: O(n) — recursion depth proportional to number count.  

💡 *Try all arithmetic combinations recursively while managing floating-point precision errors using a small epsilon.*
---

📅 19/10/2025 — [2348. Number of Zero-Filled Subarrays](https://leetcode.com/problems/number-of-zero-filled-subarrays/)  
**Level**: Medium  
**Language**: Java  
**Approach**: Counting Consecutive Zeros  

- Goal: Count all contiguous subarrays consisting entirely of zeros.  
- Use a running counter to track consecutive zeros and accumulate subarray counts dynamically.  

**Steps**:  
1. Initialize `count = 0` and `currentZeros = 0`.  
2. Traverse each element in `nums`:  
   - If the element is `0`, increment `currentZeros` and add it to `count`.  
   - If non-zero, reset `currentZeros` to `0`.  
3. Return the total `count` after traversal.  

**Time Complexity**: O(n) — single pass through the array.  
**Space Complexity**: O(1) — constant extra variables.  

💡 *Each new zero extends all previous zero subarrays, so add running length each time.*

---

📅 20/10/2025 — [1277. Count Square Submatrices with All Ones](https://leetcode.com/problems/count-square-submatrices-with-all-ones/)  
**Level**: Medium  
**Language**: Java  
**Approach**: Dynamic Programming (Optimized 1D DP)  

- Goal: Count all square submatrices in a binary matrix that contain only 1s.  
- Use dynamic programming to determine the largest square ending at each cell.  
- Optimize space to a 1D array while maintaining previous row information.  

**Steps**:  
1. Initialize a 1D DP array of size `col + 1` to store square sizes.  
2. Traverse the matrix row by row:  
   - If `matrix[i][j] == 1`, compute  
     `dp[j] = 1 + min(prev, dp[j - 1], dp[j])`,  
     where `prev` represents the top-left cell.  
   - Add `dp[j]` to the result (counts all smaller squares ending here).  
   - Update `prev` for the next iteration.  
3. Reset `dp[j] = 0` if the current cell is 0.  
4. Return the total `result`.  

**Time Complexity**: O(m × n) — each cell processed once.  
**Space Complexity**: O(n) — using a single DP array.  

💡 *Each cell’s value represents the size of the largest square ending there — summing them counts all squares efficiently.*
---

