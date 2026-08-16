class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[256];

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                if (visited[ch]) {
                    break;
                }

                visited[ch] = true;
                max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }
}