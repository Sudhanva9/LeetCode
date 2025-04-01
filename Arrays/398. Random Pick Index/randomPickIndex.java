class Solution {

    private Map<Integer, List<Integer>> map;
    private Random rand;

    public Solution(int[] nums) {
        map = new HashMap<>();
        rand = new Random();
        for (int i = 0; i < nums.length; i++) {
           map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indices = map.get(target);
        int n = indices.size();
        int r = rand.nextInt(n);
        return indices.get(r);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
