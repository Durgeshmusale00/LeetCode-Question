class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];

        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        int k = 0; // Pointer for temp

        // Compare elements from both arrays
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from nums1
        while (i < m) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        // Copy remaining elements from nums2
        while (j < n) {
            temp[k] = nums2[j];
            j++;
            k++;
        }

        // Copy merged array back to nums1
        for (int x = 0; x < m + n; x++) {
            nums1[x] = temp[x];
        }
    }
}