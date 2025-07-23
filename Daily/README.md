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
### 📅 08/07/2025 — [1751. Maximum Number of Events That Can Be Attended II](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/)
**Level**: Hard  
**Language**: Java  
**Approach**:
- Sort events by start time
- Use DP:
  - `dp[count][curIndex]` = max value achievable starting at `curIndex` with `count` events left
- At each event:
  - Either skip the current event
  - Or attend it and move to the next non-overlapping event found via binary search
- Binary search (`bisectRight`) finds the next event whose start time > current event’s end

**Time Complexity**: O(n log n * k)  
**Space Complexity**: O(n * k)
---
### 📅 09/07/2025 — [3439. Maximum Free Time after Attending K Events](https://leetcode.com/problems/maximum-free-time-after-attending-k-events/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Maintain cumulative occupied time `t` as events are processed
- For each window of `k` events:
  - Calculate free time between end of previous event and start of next
  - Deduct total time spent in the window
  - Track maximum free time found
- Slide the window of size `k` across the events

**Time Complexity**: O(n)  
**Space Complexity**: O(1)
---
### 📅 10/07/2025 — [3440. Maximum Free Time after Deleting an Event](https://leetcode.com/problems/maximum-free-time-after-deleting-an-event/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Iterate left-to-right and right-to-left:
  - Track maximum available free time before and after each event
  - Mark events that can be deleted without reducing surrounding free time
- For each event:
  - Compute potential free interval if that event were deleted
  - Otherwise subtract event duration from free interval
- Track the maximum free interval obtainable

**Time Complexity**: O(n)  
**Space Complexity**: O(n)
---
### 📅 11/07/2025 — [2402. Meeting Rooms III](https://leetcode.com/problems/meeting-rooms-iii/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Sort all meetings by start time
- Maintain two priority queues:
  - `unusedRooms` → rooms free and available immediately
  - `usedRooms` → rooms currently occupied, ordered by end time
- For each meeting:
  - Release rooms whose end time ≤ current meeting’s start
  - If a room is available, schedule the meeting there
  - Otherwise, delay the meeting until the next room is free
- Count the number of meetings per room
- Return the room used most frequently (smallest index if tie)

**Time Complexity**: O(m log n), where m = number of meetings  
**Space Complexity**: O(n)
---
### 📅 12/07/2025 — [1900. The Earliest and Latest Rounds Where Players Compete](https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/)
**Level**: Hard  
**Language**: Java  
**Approach**:
- Define DP state `F(n, f, s)` = earliest round where players `f` and `s` meet in a tournament of size `n`
- Handle symmetry:
  - `F(n, f, s) = F(n, s, f)`
  - If `f + s > n + 1` → mirror positions to reduce DP states
- Split into:
  - Players on left half
  - Players on right half
- Recursively compute for smaller tournaments
- Track both:
  - Earliest round
  - Latest round

**Time Complexity**: Exponential, but acceptable for `n ≤ 29` due to memoization  
**Space Complexity**: O(n³) DP table
---
### 📅 13/07/2025 — [2410. Match Players with Trainers](https://leetcode.com/problems/maximum-matching-of-players-with-trainers/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Sort `players` and `trainers` arrays.
- Use two pointers:
  - If current player ≤ current trainer → pair them and advance both.
  - Else, advance only trainer pointer.
- Count successful matches.

**Time Complexity**: O(n log n + m log m)  
**Space Complexity**: O(1)
---
### 📅 14/07/2025 — [1290. Convert Binary Number in a Linked List to Integer](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- Traverse the linked list from head to tail
- For each node:
  - Shift current result left by 1 bit
  - Add current node value if it’s 1
- Return the final integer value

**Time Complexity**: O(n) where n is the length of the list  
**Space Complexity**: O(1)
---
### 📅 15/07/2025 — [3136. Valid Word](https://leetcode.com/problems/valid-word/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- Check that the length of the word is at least 3
- Iterate through each character:
  - Only letters and digits are allowed
  - Must contain at least one vowel (a, e, i, o, u)
  - Must contain at least one consonant
- Return `true` only if both vowel and consonant exist and no invalid characters found

**Time Complexity**: O(n), where n = length of the string  
**Space Complexity**: O(1)
---
### 📅 16/07/2025 — [3201. Maximum Length of Subsequence With Alternating Parity](https://leetcode.com/problems/maximum-length-of-subsequence-with-alternating-parity/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- Track:
  - `count[0]`: number of even elements
  - `count[1]`: number of odd elements
  - `end[0]`: longest alternating subsequence ending in even
  - `end[1]`: longest alternating subsequence ending in odd
- At each step:
  - Extend the alternate parity’s subsequence
  - Update counts and max length

**Final Return**:
- Max of:
  - Longest subsequence with same parity
  - Longest alternating subsequence

**Time Complexity**: O(n)  
**Space Complexity**: O(1)

💡 *Previous attempts (commented) included explicit parity tracking and greedy traversal — later optimized with simple counters.*
---
### 📅 17/07/2025 — [3202. Maximum Length of a Subarray With Bitwise AND Greater Than Zero](https://leetcode.com/problems/maximum-length-of-a-subarray-with-bitwise-and-greater-than-zero/)
**Level**: Hard  
**Language**: Java  
**Approach**:
- Used a 2D `dp[k][k]` array to track transitions based on modulo values.
- `num % k` is used to reduce the number space to bounded values for efficient tracking.
- For each number, update all possible previous states:
  - `dp[prev][num] = dp[num][prev] + 1`
- Update the result as the maximum of all `dp[prev][num]` values.

**Final Return**:
- Maximum length of valid subarray after transformations based on modulo groupings.

**Time Complexity**: O(n * k)  
**Space Complexity**: O(k²)

💡 *This problem demands clever observation around modulo arithmetic and 2D transitions — tricky but efficient.*
---
### 📅 18/07/2025 — [2163. Minimum Difference in Sums After Removal of Elements](https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/)
**Level**: Hard  
**Language**: Java  
**Approach**:
- Divide array into three equal parts (length = 3n).
- Use a max heap to track minimum sum of the left part (first 2n elements) while removing elements.
- Use a min heap to track maximum sum of the right part (last 2n elements) similarly.
- Precompute prefix sums for left part (`part1`) by always removing the largest element.
- Precompute suffix sums for right part (`part2`) by always removing the smallest element.
- Calculate minimal difference of `part1[i] - part2[i]` for all valid splits.

**Time Complexity**: O(n log n) due to heap operations  
**Space Complexity**: O(n)

💡 *Heap usage for prefix and suffix sums makes this an elegant sliding window + priority queue problem.*
---
### 📅 19/07/2025 — [1233. Remove Sub-Folders from the Filesystem](https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/)
**Level**: Medium  
**Language**: Java  
**Approach**:
- Used a **`HashSet`** to store all folder paths for O(1) prefix lookup.
- For each folder:
  - Iteratively stripped the path backward (`/` split) to check if any **parent folder** exists.
  - If found, marked it as a **sub-folder**.
- Only folders with **no valid parent in the set** are added to the result.

**Time Complexity**: O(N·L)  
(where N = number of folders, L = average length of folder path)  
**Space Complexity**: O(N)

💡 *Avoids sorting or trie-based approaches by directly checking parent prefixes.*
---
### 📅 20/07/2025 — [1948. Delete Duplicate Folders in the System](https://leetcode.com/problems/delete-duplicate-folders-in-the-system/)
**Level**: Hard  
**Language**: Java  
**Approach**:
- Build a Trie from folder paths.
- Serialize each subtree using post-order DFS (e.g., `folder(child1(serial1)child2(serial2))`).
- Use a `HashMap<String, Integer>` to track frequency of each serialized subtree.
- In a second DFS, skip adding subtrees that occur more than once (i.e., duplicates).
- Return non-duplicate paths.

**Time Complexity**: O(n * L log L), where `n` is the number of folders and `L` is average path length (log L from sorting)  
**Space Complexity**: O(n * L)
---
### 📅 21/07/2025 — [1957. Delete Characters to Make Fancy String](https://leetcode.com/problems/delete-characters-to-make-fancy-string/)
**Level**: Easy  
**Language**: Java  
**Approach**:
- Use a **`StringBuilder`** to construct the result.
- Always add the first two characters (as they can't form a triple).
- From the 3rd character onward, check:
  - If it forms a **triple consecutive repetition** (`aaa`, `bbb`, etc.)
  - Skip if true, else add to result.
- Efficiently checks last two characters using `sb.charAt()`.

**Time Complexity**: O(N)  
**Space Complexity**: O(N)

💡 *Avoids unnecessary string concatenation. Efficient and clean character scan.*
---
### 📅 22/07/2025 — [1695. Maximum Erasure Value](https://leetcode.com/problems/maximum-erasure-value/)
**Level**: Medium  
**Language**: Java  
**Approach**: Sliding Window + HashSet  
- Maintain a window `[j...i]` where all elements are **unique**.
- Use `HashSet` to track seen elements.
- Move `i` forward when the current number is not in the set (expand window).
- If duplicate found, move `j` forward and subtract from `sum` until duplicate is removed (shrink window).
- Update `maxVal` with current window sum at each step.

**Time Complexity**: O(N)  
**Space Complexity**: O(N)

💡 *Classic sliding window pattern to handle subarrays with unique elements efficiently.*
---
### 📅 23/07/2025 — [1702. Maximum Binary String After Change](https://leetcode.com/problems/maximum-binary-string-after-change/)
**Level**: Medium  
**Language**: Java  
**Approach**: Greedy + Counting  
- All operations convert any `00` into `10`.
- Idea is to push all `0`s towards right greedily.
- Count number of `0`s after the first `0` (let’s say `zeroCount`).
- First `0` becomes `1`, then next `zeroCount - 1` `0`s become `1`, and one `0` will remain and get converted to `0` at correct place.

**Steps**:
- Traverse the string.
- Count how many `0`s are there and where the first `0` occurs.
- Construct result string:
  - From start to `firstZeroIndex`: all `1`s
  - Then one `0` followed by `zeroCount - 1` `1`s
  - Remaining suffix (rest of string): all `1`s

**Time Complexity**: O(N)  
**Space Complexity**: O(N)

💡 *Clever greedy solution based on transformation behavior analysis.*
---

### 📈 Progress Summary 

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
| 08/07/2025 | 1751       | Maximum Number of Events That Can Be Attended II            | Hard    | ✅      |
| 09/07/2025 | 3439       | Maximum Free Time after Attending K Events                  | Medium  | ✅      |
| 10/07/2025 | 3440       | Maximum Free Time after Deleting an Event                   | Medium  | ✅      |
| 11/07/2025 | 2402       | Meeting Rooms III                                           | Hard    | ✅      |
| 12/07/2025 | 1900       | The Earliest and Latest Rounds Where Players Compete        | Hard    | ✅      |
| 13/07/2025 | 2410       | Match Players with Trainers                                 | Medium  | ✅      |
| 14/07/2025 | 1290       | Convert Binary Number in a Linked List to Integer           | Easy    | ✅      |
| 15/07/2025 | 3136       | Valid Word                                                  | Easy    | ✅      |
| 16/07/2025 | 3201       | Maximum Length of Subsequence With Alternating Parity       | Easy    | ✅      |
| 17/07/2025 | 3202       | Maximum Length of a Subarray With Bitwise AND Greater
                                                                               Than Zero| Hard    | ✅      | 
| 18/07/2025 | 2163       | Minimum Difference in Sums After Removal of Elements        | Hard    | ✅      |
| 19/07/2025 | 1233       | Remove Sub-Folders from the Filesystem                      | Medium  | ✅      |
| 20/07/2025 | 1948       | Delete Duplicate Folders in the System                      | Hard    | ✅      |
| 21/07/2025 | 1957       | Delete Characters to Make Fancy String                      | Easy    | ✅      |
| 22/07/2025 | 1695       | Maximum Erasure Value                                       | Medium  | ✅      |
| 23/07/2025 | 1702       | Maximum Binary String After Change                          | Medium  | ✅      |



                                                                                    
                                                                            



















---

✅ Stay consistent. Daily problems → Daily growth!
