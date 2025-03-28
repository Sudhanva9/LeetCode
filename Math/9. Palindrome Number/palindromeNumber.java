class Solution {
    public boolean isPalindrome(int x) {
        // Negative number
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + (x % 10);
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
}
