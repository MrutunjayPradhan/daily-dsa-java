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

### 📈 Progress Summary (Day 4 - 23/06/2025)

| Date       | Problem ID | Title                                             | Level   | Status |
|------------|------------|---------------------------------------------------|---------|--------|
| 20/06/2025 | 3084       | Maximum Manhattan Distance After K Changes       | Medium  | ✅      |
| 21/06/2025 | 3085       | Minimum Deletions to Make String K-Special       | Medium  | ✅      |
| 22/06/2025 | 2138       | Divide a String Into Groups of Size k            | Easy    | ✅      |
| 23/06/2025 | 2081       | Sum of k-Mirror Numbers                          | Hard    | ✅      |

---

✅ Keep checking in daily for new updates and consistent documentation!
