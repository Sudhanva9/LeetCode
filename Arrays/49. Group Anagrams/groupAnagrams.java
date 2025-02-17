// Apprach 1: Sorting

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //Edge Case
        if (strs.length == 0) {
            return new ArrayList();
        }

        Map<String, List> ans = new HashMap<String, List>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }

            ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }
}
