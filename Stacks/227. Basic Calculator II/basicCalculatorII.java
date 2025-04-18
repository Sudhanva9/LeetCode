// Without Stack
class Solution {
    public int calculate(String s) {
        // Base Case
        if (s == null || s.isEmpty()) return 0;

        int length = s.length();
        int currentNumber = 0, lastNumber = 0, res = 0;

        char operation = '+';

        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    res += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        res += lastNumber;
        return res;
    }
}
