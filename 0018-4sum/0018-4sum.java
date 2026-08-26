import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        if (nums.length < 4) {
            return list;
        }

        int i = 0;

        while (i < nums.length - 3) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            int j = i + 1;

            while (j < nums.length - 2) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                for (int k = j + 1; k < nums.length - 1; k++) {

                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    long required =
                        (long) target - nums[i] - nums[j] - nums[k];

                    if (required < Integer.MIN_VALUE ||
                        required > Integer.MAX_VALUE) {
                        continue;
                    }

                    if (binarySearch(nums, k + 1, nums.length - 1, (int) required)) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], (int) required));
                    }
                }

                j++;
            }

            i++;
        }

        return list;
    }

    public boolean binarySearch(int[] arr, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return false;
    }
}