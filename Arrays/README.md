# Arrays Problems

- [LeetCode 56. Merge Intervals](https://leetcode.com/problems/merge-intervals)  
  - **Approach:**  
    - Sort intervals by starting index (`interval[0]`).
    - Create an empty list for merged intervals.
    - For each interval:
      - If the list is empty OR current interval’s start > last interval’s end → add interval directly.
      - Otherwise, merge by updating the end of the last interval to `max(current end, last end)`.
    - Return the list converted to an array.
  - **Time Complexity:** O(n log n)
  - **Space Complexity:** O(n)

