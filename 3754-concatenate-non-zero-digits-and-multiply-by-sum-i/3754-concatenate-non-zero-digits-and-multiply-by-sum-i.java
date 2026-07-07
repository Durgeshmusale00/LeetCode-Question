class Solution {
    static long nonZero = 0;
    static int sum = 0;

    public long sumAndMultiply(int n) {
        nonZero = 0;
        sum = 0;

        nonZeronum(n);
        return nonZero * sum;
    }

    public void nonZeronum(int n) {
        if (n == 0) {
            return;
        }

        nonZeronum(n / 10);   // Process left to right

        int digit = n % 10;
        if (digit != 0) {
            nonZero = nonZero * 10 + digit;
            sum += digit;
        }
    }
}