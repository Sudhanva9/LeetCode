class Solution {

    private int[] prefixSum;

    public Solution(int[] w) {
        int n = w.length;
        prefixSum = new int[n];
        prefixSum[0] = w[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = w[i] + prefixSum[i - 1];  
        }
    }
    
    public int pickIndex() {
        double target = new Random().nextInt(prefixSum[prefixSum.length - 1]) + 1;
        int left = 0;
        int right = prefixSum.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
