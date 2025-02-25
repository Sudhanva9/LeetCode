class Solution {
    public int search(int[] nums, int target) {
       int Left = 0;
       int Right = nums.length - 1;

       while (Left <= Right) {
        int mid = Left + ((Right - Left) / 2);

        if (target < nums[mid]) {
            Right = mid - 1;
        } else if (target > nums[mid]){
            Left = mid + 1;
        } else {
            return mid;
        }
       }
       return -1;  
    }
}
