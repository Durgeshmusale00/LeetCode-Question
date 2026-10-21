class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        s = s.toLowerCase();
        for (int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ans++;
            }
        }
        int maxAns = ans;

        int i = 0;
        int j = k;
        while (j < s.length()) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ans--;
            }
            char ch1 = s.charAt(j);
            if (ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') {
                ans++;
            }
            maxAns = Math.max(maxAns, ans);
            j++;
            i++;
        }
        return maxAns;
    }
}