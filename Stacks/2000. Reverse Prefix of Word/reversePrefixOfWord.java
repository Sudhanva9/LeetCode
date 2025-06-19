class Solution {
    public String reversePrefix(String word, char ch) {

        StringBuilder res = new StringBuilder();
        if (word == null || word.isEmpty() || ch == '\0') {
            return res.toString();
        }

        Stack<Character> reverse = new Stack<>();

        int i = 0;
        while (i < word.length()) {
            reverse.add(word.charAt(i));
            if (word.charAt(i) == ch) {
                i += 1;
                break;
            }
            i += 1;
        }

        if (i == word.length() && word.charAt(i - 1) != ch) {
            return word;
        }

        while (!reverse.isEmpty()) {
            res.append(reverse.pop());
        }
        for (int k = i; k < word.length(); k++) {
                res.append(word.charAt(k));
        }

        return res.toString();
    }
}
