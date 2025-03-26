class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // For all the independent intervals, the same room(1) can be used. If there is a dependency, it requires a seperate room.
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < intervals.length; ++i) {
            if (!pq.isEmpty() && pq.peek() <= intervals[i][0]) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }

        return pq.size();
    }
}
