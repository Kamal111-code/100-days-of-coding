# Longest Substring with no repeating Characters
Problem statement:

Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.


#Solution
Brute force approach:
 We will use a hash array to store the frequenct of characters. If frequency > 1 then Break.

Sliding window approach:
We initially take l=0,r=0 and then move r as long as it does not break our condition. If our condition breaks then we move l
