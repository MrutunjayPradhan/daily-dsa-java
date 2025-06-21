### 📅 LeetCode Daily Challenge - [3085. Minimum Deletions to Make String K-Special](https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/)
**Date**: 21/06/2025 
**Language**: Java  
**Approach**:
- Count character frequencies
- Try minimizing deletions by treating each frequency as a baseline
- Greedy deletion outside allowed frequency range `[a, a + k]`