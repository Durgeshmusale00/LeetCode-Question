class Solution {
    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
         if(blocks.charAt(i) == 'W') count++;
        }

        int finalAns = count;
        int left = 0;
        int right = k;
        while(right < blocks.length()){
            if(blocks.charAt(left) == 'W'){
                count--;
            }
            if(blocks.charAt(right) == 'W'){
                count++;
            }

            finalAns = Math.min(count, finalAns);
            right++;
            left++;
        }
        return finalAns;
    }
}