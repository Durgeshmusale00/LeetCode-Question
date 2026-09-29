class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            // Odd 
            int left = i;
            int right = i;
            while (left >= 0 && right < n) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }

                int length = right - left + 1;

                if (length > maxLength) {
                    maxLength = length;
                    start = left;
                }

                left--;
                right++;
            }
            // Even 
            left = i;
            right = i + 1;
            while (left >= 0 && right < n) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                int length = right - left + 1;
                if (length > maxLength) {
                    maxLength = length;
                    start = left;
                }
                left--;
                right++;
            }
        }

        return s.substring(start, start + maxLength);
    }
}