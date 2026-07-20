import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        // 0 = not computed, 1 = true, -1 = false
        int[] memo = new int[s.length()];

        return helper(s, 0, wordSet, memo);
    }

    private boolean helper(String s, int i, Set<String> wordSet, int[] memo) {
        int n = s.length();

        // Reached the end of the string
        if (i == n) {
            return true;
        }

        // Already computed
        if (memo[i] != 0) {
            return memo[i] == 1;
        }

        // Try every possible prefix starting at index i
        for (int j = i; j < n; j++) {
            String word = s.substring(i, j + 1);

            if (wordSet.contains(word) && helper(s, j + 1, wordSet, memo)) {
                memo[i] = 1;
                return true;
            }
        }

        memo[i] = -1;
        return false;
    }
}