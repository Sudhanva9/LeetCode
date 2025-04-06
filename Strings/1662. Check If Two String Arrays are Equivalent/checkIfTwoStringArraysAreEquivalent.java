class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = 0;
        int w2 = 0;

        int i = 0; 
        int j = 0;

        while (w1 < word1.length && w2 < word2.length) {
            if (word1[w1].charAt(i) != word2[w2].charAt(j)) {
                return false;
            }

            i = i + 1;
            j = j + 1;

            if (i == word1[w1].length()) {
                w1 += 1;
                i = 0;
            }
            if (j == word2[w2].length()) {
                w2 += 1;
                j = 0;
            }

        }

        if (w1 != word1.length || w2 != word2.length) {
            return false;
        }

        return true;
    }
}
