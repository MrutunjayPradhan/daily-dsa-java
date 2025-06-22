### 📅 LeetCode Daily Challenge - [3085. Minimum Deletions to Make String K-Special](https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/)
**Date**: 21/06/2025 
**Language**: Java  
**Approach**:
- Count character frequencies
- Try minimizing deletions by treating each frequency as a baseline
- Greedy deletion outside allowed frequency range `[a, a + k]`

### ✂️ Problem - [2138. Divide a String Into Groups of Size k](https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/)
**Level**: Easy
**Date**: 22/06/2025 
**Language**: Java    
**Approach**:
- Use a loop to divide the string into chunks of size `k`
- Fill the last chunk with the provided character if it's incomplete
- Return as an array of strings

**Time Complexity**: O(n)  
**Space Complexity**: O(n)  
