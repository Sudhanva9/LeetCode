class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (R > k) {
                window.remove(nums[L]);
                L += 1;
            }

            if (window.contains(nums[R])) {
                return true;
            }
            window.add(nums[R]);
        }

        return false;
    }
}
