class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPointer = 0;
        int abbrPointer = 0;

        // Base Case
        if (word == null || abbr == null) return false;

        while (wordPointer < word.length() && abbrPointer < abbr.length()) {
            // Check if the character is a digit
            if (Character.isDigit(abbr.charAt(abbrPointer))) {
                if (abbr.charAt(abbrPointer) == '0') return false;

                int total = 0;
                while (abbrPointer < abbr.length() && Character.isDigit(abbr.charAt(abbrPointer))) {
                    total = total * 10 + abbr.charAt(abbrPointer) - '0';
                    abbrPointer++;
                }
                wordPointer += total;                
            } else {
                if (word.charAt(wordPointer) != abbr.charAt(abbrPointer)) return false;
                wordPointer++;
                abbrPointer++;
            }
        }
        return wordPointer == word.length() && abbrPointer == abbr.length();
    }
}
