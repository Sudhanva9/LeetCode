class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int res = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount += 1;
            } else {
                if (openCount == 0) res += 1;
                openCount = Math.max(openCount - 1, 0);
            }
        }

        return openCount + res;
    }
}
