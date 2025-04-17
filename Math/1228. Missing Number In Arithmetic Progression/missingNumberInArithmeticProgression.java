class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        int diff = (arr[n - 1] - arr[0]) / n;
        int expected = arr[0];

        for (int val : arr) {
            if (val != expected) break;
            expected += diff;
        }       
        return expected;
    }
}
