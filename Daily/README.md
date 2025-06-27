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

### 📈 Progress Summary (Day 5 - 24/06/2025)

| Date       | Problem ID | Title                                            | Level   | Status  |
|------------|------------|--------------------------------------------------|---------|---------|
| 20/06/2025 | 3084       | Maximum Manhattan Distance After K Changes       | Medium  | ✅      |
| 21/06/2025 | 3085       | Minimum Deletions to Make String K-Special       | Medium  | ✅      |
| 22/06/2025 | 2138       | Divide a String Into Groups of Size k            | Easy    | ✅      |
| 23/06/2025 | 2081       | Sum of k-Mirror Numbers                          | Hard    | ✅      |
| 24/06/2025 | 2200       | Find All K-Distant Indices in an Array           | Easy    | ✅      |
| 27/06/2025 | 2014       | Longest Subsequence Repeated k Times             | Hard    | ✅      |


---

✅ Stay consistent. Daily problems → Daily growth!
