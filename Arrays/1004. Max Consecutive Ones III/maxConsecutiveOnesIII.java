class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxWindow = 0;
        int numZeros = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                numZeros += 1;
            }

            while (numZeros > k) {
                if (nums[l] == 0) {
                    numZeros -= 1;
                }
                l += 1;
            }
            
            maxWindow = Math.max(maxWindow, r - l + 1);
        }
        return maxWindow;
    }
}
