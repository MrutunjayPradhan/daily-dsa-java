# 🗓️ LeetCode Daily Challenge Log - June 2025

This folder contains my daily LeetCode challenge solutions for June 2025. Each entry includes the problem link, difficulty level, date, language, and a brief approach.

---

### 📅 20/06/2025 — [3084. Maximum Manhattan Distance After K Changes](https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Count the occurrences of directions (`N`, `S`, `E`, `W`)
- Use at most `k` changes to balance North/South first, then East/West
- Each modification increases distance by `2`
- Track the maximum Manhattan distance possible at each step

---

### 📅 21/06/2025 — [3085. Minimum Deletions to Make String K-Special](https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Count frequency of each character
- Try different frequency baselines
- Use a greedy approach to remove characters outside `[a, a + k]` frequency window
- Minimize deletions needed

---

### 📅 22/06/2025 — [2138. Divide a String Into Groups of Size k](https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- Iterate through the string, taking groups of size `k`
- If the last group is shorter, fill it using the given `fill` character
- Return the result as an array of string chunks

---

### 📅 23/06/2025 — [2081. Sum of k-Mirror Numbers](https://leetcode.com/problems/sum-of-k-mirror-numbers/)
**Level**: Hard  
**Language**: Java  
**Approach**:
- Generate palindromes in base-10 by mirroring digits
- For each candidate, check if it is also a palindrome in base-`k`
- Continue until `n` such k-mirror numbers are found
- Return the sum of all valid numbers found

---

### 📅 24/06/2025 — [2200. Find All K-Distant Indices in an Array](https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- For each index `i`, check the window `[i - k, i + k]`
- If any index `j` within the window contains the `key`, add `i` to the result
- Use `lastAdded` to avoid adding duplicates
- Efficiently skips extra work once match is found

---
### 📅 27/06/2025 — [2014. Longest Subsequence Repeated k Times](https://leetcode.com/problems/longest-subsequence-repeated-k-times/)
**Level**: Hard  
**Language**: Java  
**Approach**:
- Count frequency of each character in the string
- Keep only characters that appear at least `k` times as candidates
- Use BFS to try all subsequences built from candidate characters
- Check whether a candidate repeats at least `k` times as a subsequence
- Always update result if a longer or lexicographically larger subsequence is found

**Time Complexity**: Exponential in the worst case (BFS of all subsequences)  
**Space Complexity**: Potentially exponential due to BFS queue
---
### 📅 28/06/2025 — [2099. Find Subsequence of Length K With the Largest Sum](https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- Sort a copy of the array to determine the k largest values
- Identify the threshold value (smallest among the top k elements)
- Count how many times the threshold occurs in the top k
- Iterate through the original array to preserve relative order:
  - Add values greater than threshold
  - For threshold values, only include as many as counted
- Ensures the subsequence sums up to the largest possible value and preserves order

**Time Complexity**: O(n log n) due to sorting  
**Space Complexity**: O(n) for extra arrays
---
### 📅 29/06/2025 — [1498. Number of Subsequences That Satisfy the Given Sum Condition](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Sort the array to enable two-pointer traversal
- For each `left` index, check if the smallest + largest is ≤ target
- If so, all subsets between `left` and `right` are valid
- Count these as `2^(right - left)` using precomputed powers of 2
- Otherwise, decrease `right` to find a smaller max element
- Keep results modulo \(10^9 + 7\)

**Time Complexity**: O(n log n) due to sorting  
**Space Complexity**: O(n) for power array
---

### 📅 30/06/2025 — [594. Longest Harmonious Subsequence](https://leetcode.com/problems/longest-harmonious-subsequence/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- Count the frequency of each number using a hashmap
- For each unique number, check if `(num + 1)` exists in the map
- If it does, the combined count of `num` and `num + 1` forms a harmonious subsequence
- Keep track of the maximum length found

**Time Complexity**: O(n)  
**Space Complexity**: O(n)
---
### 📅 01/07/2025 — [3330. Count Possible Strings After Compression](https://leetcode.com/problems/count-possible-strings-after-compression/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- Iterate through the string, comparing each character with its previous one
- Increment the count every time two consecutive characters are equal
- The result is the number of ways the compressed string could have originally formed

**Time Complexity**: O(n)  
**Space Complexity**: O(1)
---
### 📅 02/07/2025 — [3333. Count Possible Strings After Compression II](https://leetcode.com/problems/count-possible-strings-after-compression-ii/) (seek help of ai) just want to be honest with my progress .
**Level**: Hard  
**Language**: Java  
**Approach**:
- First, calculate all consecutive run lengths in the string
- Compute the initial product of run lengths
- If the number of runs ≥ k, the total count remains unchanged
- Otherwise, use DP to determine how many ways runs could have been split into ≤ k segments
- Subtract invalid splits from the total count, modulo \(10^9 + 7\)

**Time Complexity**: O(k·n)  
**Space Complexity**: O(k)
---
### 📅 03/07/2025 — [3304. Find the K-th Character in String Game I](https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- Interpret `k` as a position in a string generated by a labeling pattern
- Repeatedly subtract the largest power of two ≤ k to trace how many steps were needed
- The number of subtractions determines the letter's offset from `'a'`
- Return the corresponding character

**Time Complexity**: O(log k)  
**Space Complexity**: O(1)
---
### 📅 04/07/2025 — [3307. Find the K-th Character in String Game II](https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Decrement `k` to 0-based index
- Traverse the bits of `k` and for every bit set to 1, accumulate the corresponding `operations[i]`
- Final character is determined by `'a' + (sum % 26)`

**Time Complexity**: O(log k)  
**Space Complexity**: O(1)
---
### 📅 05/07/2025 — [1394. Find Lucky Integer in an Array](https://leetcode.com/problems/find-lucky-integer-in-an-array/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- Count the frequency of each number using a HashMap
- Iterate through map entries:
  - If `number == frequency`, it’s a lucky number
  - Keep track of the largest lucky number found
- Return the maximum lucky number, or -1 if none exist

**Time Complexity**: O(n)  
**Space Complexity**: O(n)
---
### 📅 06/07/2025 — [1865. Finding Pairs With a Certain Sum](https://leetcode.com/problems/finding-pairs-with-a-certain-sum/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Store `nums1` as-is and maintain a frequency map for `nums2`
- In `add(index, val)`, update `nums2[index]` and adjust counts in the frequency map
- In `count(tot)`, for each number `num` in `nums1`, check if `tot - num` exists in the frequency map of `nums2`
- Accumulate the total count of such pairs

**Time Complexity**:
- Constructor: O(n)
- add(): O(1)
- count(): O(n)

**Space Complexity**: O(n)
---
### 📅 07/07/2025 — [1353. Maximum Number of Events That Can Be Attended](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Sort events by their start day
- For each day, push events starting that day into a min-heap sorted by end day
- Remove any events whose end day has already passed
- Attend one event each day by removing the earliest finishing event from the heap

**Time Complexity**: O(n log n)  
**Space Complexity**: O(n)
---

### 📈 Progress Summary Solved the daly problem will update soon

| Date       | Problem ID | Title                                                       | Level   | Status  |
|------------|------------|-------------------------------------------------------------|---------|---------|
| 20/06/2025 | 3084       | Maximum Manhattan Distance After K Changes                  | Medium  | ✅      |
| 21/06/2025 | 3085       | Minimum Deletions to Make String K-Special                  | Medium  | ✅      |
| 22/06/2025 | 2138       | Divide a String Into Groups of Size k                       | Easy    | ✅      |
| 23/06/2025 | 2081       | Sum of k-Mirror Numbers                                     | Hard    | ✅      |
| 24/06/2025 | 2200       | Find All K-Distant Indices in an Array                      | Easy    | ✅      |
| 27/06/2025 | 2014       | Longest Subsequence Repeated k Times                        | Hard    | ✅      |
| 28/06/2025 | 2099       | Find Subsequence of Length K With the Largest Sum           | Easy    | ✅      |
| 29/06/2025 | 1498       | Number of Subsequences That Satisfy the Given Sum Condition | Medium  | ✅      |
| 30/06/2025 | 594        | Longest Harmonious Subsequence                              | Easy    | ✅      |
| 01/07/2025 | 3330       | Count Possible Strings After Compression                    | Easy    | ✅      |
| 02/07/2025 | 3333       | Count Possible Strings After Compression II                 | Hard    | ✅      |
| 03/07/2025 | 3304       | Find the K-th Character in String Game I                    | Easy    | ✅      |
| 04/07/2025 | 3307       | Find the K-th Character in String Game II                   | Medium  | ✅      |
| 05/07/2025 | 1394       | Find Lucky Integer in an Array                              | Easy    | ✅      |
| 06/07/2025 | 1865       | Finding Pairs With a Certain Sum                            | Medium  | ✅      |
| 07/07/2025 | 1353       | Maximum Number of Events That Can Be Attended               | Medium  | ✅      |











---

✅ Stay consistent. Daily problems → Daily growth!
