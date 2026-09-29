class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    int length = j - i + 1;
                    if (length > maxLength) {
                        maxLength = length;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    // Check whether s[i...j] is palindrome
    public boolean isPalindrome(String s, int i, int j) {

        while (i < j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}