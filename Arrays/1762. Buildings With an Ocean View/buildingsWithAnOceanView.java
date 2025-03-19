class Solution {
    public int[] findBuildings(int[] heights) {
        
        Deque<Integer> res = new LinkedList<>();
        int maxHeight = 0;

        if (heights == null || heights.length == 0) {
            return new int[0];
        }
        
        for (int i = heights.length - 1; i >=0; i--) {
            int curHeight = heights[i];
            if (curHeight > maxHeight) {
                res.addFirst(i);
                maxHeight = curHeight;
            }
        }

        int[] resArray = new int[res.size()];
        int index = 0;
        while (!res.isEmpty()) {
            resArray[index++] = res.poll();
        }

        return resArray;
    }
}
