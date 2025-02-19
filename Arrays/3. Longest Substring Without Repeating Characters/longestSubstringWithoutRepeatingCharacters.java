class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> mySet = new HashSet<>();
        int L = 0;
        int res = 0;

        for (int R = 0; R < s.length(); R++) {
            while (mySet.contains(s.charAt(R))) {
                mySet.remove(s.charAt(L));
                L += 1;
            }
            mySet.add(s.charAt(R));
            res = Math.max((R-L+1), res);
        }
        return res;
    }
}
