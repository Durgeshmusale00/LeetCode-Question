class Solution {

    public String getPermutation(int n, int k) {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int factorial = 1;

        for (int i = 1; i < n; i++) {
            factorial *= i;
        }

        StringBuilder ans = new StringBuilder();

        // Convert k to 0-based
        k--;

        helper(numbers, k, factorial, ans);

        return ans.toString();
    }

    public void helper(ArrayList<Integer> numbers, int k, int factorial, StringBuilder ans) {

        // Base case
        if (numbers.size() == 0) {
            return;
        }

        int index = k / factorial;

        ans.append(numbers.get(index));
        numbers.remove(index);

        k = k % factorial;

        if (numbers.size() > 0) {
            factorial = factorial / numbers.size();
        }

        helper(numbers, k, factorial, ans);
    }
}