// VARIANT: What if you had to return the Kth missing positive number from the leftmost element?

class Solution1539Variant {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - arr[0] - mid;

            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return arr[0] + k + right;
    }
}
