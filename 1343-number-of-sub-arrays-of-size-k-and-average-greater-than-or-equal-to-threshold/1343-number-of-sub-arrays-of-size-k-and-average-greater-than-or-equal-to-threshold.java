class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int ans = 0;
        if (sum / k >= threshold) {
            ans++;
        }
        
        int left = 0;
        int right = k;
        while (right < arr.length) {
            sum = sum - arr[left] + arr[right];
            if (sum / k >= threshold) {
                ans++;
            }
            left++;
            right++;
        }
        return ans;
    }
}