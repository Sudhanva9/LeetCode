// Two Pointers

class Solution {
    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int res = 0;

        while (L < R) {
            int area = (R - L) * Math.min(height[L], height[R]);
            res = Math.max(area, res);

            if (height[L] < height[R]) {
                L += 1;
            }
            else {
                R -= 1;
            }
        }
        return res;
    }
}
