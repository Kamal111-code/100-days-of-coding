import java.util.HashMap;
import java.util.Map;

class Solution {

    // Sliding Window Approach
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // Shrink window until there are no duplicates
            while (map.get(currentChar) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
