// SORTING

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = nums.length - 1;

        Arrays.sort(nums);

        if (nums[n - 1] != n) return n;
        else if (nums[0] != 0) return 0;

        for (int i = 1; i < n; i++) {
            int res = nums[i - 1] + 1;
            if (nums[i] != res) {
                return res;
            }
        }

        return -1;
    }
}
