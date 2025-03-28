// KADANE'S ALGORITHM

class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = nums[0];

        for (int num : nums) {
           if (curSum < 0) {
            curSum = 0;
           }
           curSum += num;
           maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}

// SLIDING WINDOW

class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = nums[0];
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (curSum < 0) {
                curSum = 0;
                l = r;
            }

            curSum += nums[r];
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
