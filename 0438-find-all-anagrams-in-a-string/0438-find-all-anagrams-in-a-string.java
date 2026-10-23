class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
         if (p.length() > s.length()) {
            return ans;
        }
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapp = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            mapp.put(ch, mapp.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            maps.put(ch, maps.getOrDefault(ch, 0) + 1);
              if (right - left + 1 > p.length()) {
                char outgoing = s.charAt(left);
                maps.put(outgoing, maps.get(outgoing) - 1);

                if (maps.get(outgoing) == 0) {
                    maps.remove(outgoing);
                }

                left++;
            }

            if (right - left + 1 == p.length() && maps.equals(mapp)) {
                ans.add(left);
            }
        }
        return ans;
    }
}