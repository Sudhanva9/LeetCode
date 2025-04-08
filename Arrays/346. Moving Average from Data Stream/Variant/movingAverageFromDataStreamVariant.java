class MovingAverage {

    public List<Integer> computeAverage(int[] nums, int size) {
        List<Integer> res = new ArrayList<>();
        int windowSum = 0;

        for (int r = 0; r < nums.length; r++) {
            windowSum += nums[r];

            int l = r - size;
            if (l >= 0) {
                windowSum -= nums[l];
            }
            
            if (r >= size - 1) {
                res.add(windowSum / size);
            }
        }
        return res;
    }
}
