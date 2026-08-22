import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        // Frequency map of t
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Frequency map of current window
        HashMap<Character, Integer> map1 = new HashMap<>();

        int i = 0;
        int j = 0;
        int n = s.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (j < n) {

            // Expand the window until it becomes valid
            while (j < n && !check(map, map1)) {
                char ch = s.charAt(j);

                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

                j++;
            }

            // Minimize the window while it remains valid
            while (check(map, map1)) {

                if (j - i < minLen) {
                    minLen = j - i;
                    start = i;
                }

                char ch = s.charAt(i);

                map1.put(ch, map1.get(ch) - 1);

                i++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }

    public boolean check(
            HashMap<Character, Integer> map,
            HashMap<Character, Integer> map1) {

        for (Character c : map.keySet()) {

            int charAnt = map.get(c); // required count
            int charCnt = map1.getOrDefault(c, 0); // window count

            // Window must contain AT LEAST the required count
            if (charCnt < charAnt) {
                return false;
            }
        }

        return true;
    }
}