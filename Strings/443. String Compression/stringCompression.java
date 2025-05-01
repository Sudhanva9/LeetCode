class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int res = 0;
        while (i < chars.length) {
            int groupLen = 1;

            while (i + groupLen < chars.length && chars[i + groupLen] == chars[i]) {
                groupLen++;
            }

            chars[res++] = chars[i];
            if (groupLen > 1) {
                for (char c : Integer.toString(groupLen).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLen;
        }
        return res;
    }
}
