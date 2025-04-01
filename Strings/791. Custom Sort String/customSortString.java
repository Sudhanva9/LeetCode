class Solution {
    public String customSortString(String order, String s) {

        Map<Character, Integer> frequency = new HashMap<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char letter = s.charAt(i);
            frequency.put(letter, frequency.getOrDefault(letter, 0) + 1);
        }

        int k = order.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < k; i++) {
            char letter = order.charAt(i);
            while (frequency.getOrDefault(letter, 0) > 0) {
                res.append(letter);
                frequency.put(letter, frequency.get(letter) - 1);
            }
        }

        for (char letter : frequency.keySet()) {
            int count = frequency.get(letter);
            while (count > 0) {
                res.append(letter);
                count--;
            }
        }
        return res.toString();
    }
}
