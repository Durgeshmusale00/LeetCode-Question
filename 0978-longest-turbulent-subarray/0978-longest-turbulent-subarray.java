
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int left = 0;
        int right = 1;
        int max = 1;
        int n = arr.length;

        while (right < n) {
            if (arr[right] == arr[right - 1]) {
                max = Math.max(max, right - left);
                left = right;
                right++;
                continue;
            }

            while (right + 1 < n && iscurrentIndexTurbulent(arr, right)) {
                right++;
            }

            max = Math.max(max, right - left + 1);

            if (right == n - 1) {
                break;
            }

            left = right;
            right++;
        }

        return max;
    }

    private boolean iscurrentIndexTurbulent(int[] arr, int k) {
        return (arr[k] > arr[k - 1] && arr[k] > arr[k + 1]) ||
               (arr[k] < arr[k - 1] && arr[k] < arr[k + 1]);
    }
}
