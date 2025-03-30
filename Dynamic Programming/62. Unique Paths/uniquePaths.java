// Dynamic Programming (Optimal)

class Solution {
    public int uniquePaths(int m, int n) {
        int[] rows = new int[n];
        Arrays.fill(rows, 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                rows[j] += rows[j + 1];
            }
        }

        return rows[0];
    }
}
