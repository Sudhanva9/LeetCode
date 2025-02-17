class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix = nums[i] * prefix;
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = postfix * res[i];
            postfix = postfix * nums[i];
        }

        return res;
    }
}
