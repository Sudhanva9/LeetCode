// APPROACH 1

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] newArray = new int[nums.length];
        int left = 0; 
        int right = n;

        for (int i = 0; i < nums.length; i+=2) {
            newArray[i] = nums[left];
            newArray[i + 1] = nums[right];
            left++;
            right++;
        }

        return newArray;
    }
}

