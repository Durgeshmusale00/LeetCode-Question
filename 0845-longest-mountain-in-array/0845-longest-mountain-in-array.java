class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int ans = 0;

        for (int i = 1; i < n - 1; i++) {

            // Check if current element is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {

                int leftBoundary = i;
                int rightBoundary = i;

                // Expand towards left
                while (leftBoundary > 0 &&
                       arr[leftBoundary] > arr[leftBoundary - 1]) {
                    leftBoundary--;
                }

                // Expand towards right
                while (rightBoundary < n - 1 &&
                       arr[rightBoundary] > arr[rightBoundary + 1]) {
                    rightBoundary++;
                }

                ans = Math.max(ans, rightBoundary - leftBoundary + 1);
            }
        }

        return ans;
    }
}