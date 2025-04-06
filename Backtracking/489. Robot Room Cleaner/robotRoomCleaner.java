/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    private final int[][] directions = {
        {-1, 0}, // top
        {0, 1}, // right
        {1, 0}, // down
        {0, -1} // left
    };

    private Set<String> visited = new HashSet<>();

    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0);
    }

    private void dfs(Robot robot, int direction, int row, int col) {
        robot.clean();
        visited.add(row + "," + col);

        for (int i = 0; i < 4; i++) {
            int newDir = (direction + i) % 4;
            int newRow = row + directions[newDir][0];
            int newCol = col + directions[newDir][1];

            String pos = newRow + "," + newCol;
            if (!visited.contains(pos) && robot.move()) {
                dfs(robot, newDir, newRow, newCol);
                // Backtrack to previous position
                goBack(robot);
            }
            robot.turnRight();
        }
    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
