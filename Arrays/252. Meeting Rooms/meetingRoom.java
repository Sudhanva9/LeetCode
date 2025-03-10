class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // the other intervals shouldn't be greater than / equal to the start AND lesser than / equal to the end.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length - 1; i++){
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
