class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        Map<Integer, List<Integer>> diagonalDict = new HashMap<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                diagonalDict.computeIfAbsent(r + c, k -> new ArrayList<>()).add(mat[r][c]);
            }
        }

        List<Integer> res = new ArrayList<>(); 
        int key = 0;

        while (diagonalDict.containsKey(key)) {
            if (key % 2 == 0) {
                Collections.reverse(diagonalDict.get(key));
            }
            res.addAll(diagonalDict.get(key));
            key++;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
