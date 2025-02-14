// FOR LOOP

class Solution {
    public int removeElement(int[] nums, int val) {
        int writer = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != val) {
                nums[writer] = nums[r];
                writer += 1;
            }
        }

        return writer;
    }
}

// WHILE LOOP

class Solution {
    public int removeElement(int[] nums, int val) {
        int writer = 0;
        int reader = 0;

        while (reader < nums.length) {
            if (nums[reader] == val){
                reader++;
            } else {
                nums[writer] = nums[reader];
                reader++;
                writer++;
            }
        }

        return writer;
    }
}
