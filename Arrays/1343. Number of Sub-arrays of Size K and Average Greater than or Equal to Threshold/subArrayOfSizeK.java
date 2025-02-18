class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int curSum = 0;

        for (int i = 0; i < k-1; i++) {
            curSum += arr[i];
        } 

        for (int L = 0; L < (arr.length - k+1); L++) {
            curSum += arr[L + k - 1];

            if ((curSum / k) >= threshold) {
                res += 1;
            }

            curSum -= arr[L];
        }

        return res;
    }
}
