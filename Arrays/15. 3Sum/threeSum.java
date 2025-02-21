// Two Pointers

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int threeSum = nums[i] + nums[L] + nums[R];

                if (threeSum > 0) {
                    R -= 1;
                }
                else if (threeSum < 0) {
                    L += 1;
                }
                else {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    L += 1;

                    while (nums[L] == nums[L - 1] && L < R) {
                        L += 1;
                    }
                }
            }
        }
        return res;
    }
}
