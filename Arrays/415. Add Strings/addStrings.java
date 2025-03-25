class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        while (l1 >= 0 || l2 >= 0) {
            int x1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int x2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;

            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;

            res.append(value);
            l1--;
            l2--;
        }

        if (carry != 0) res.append(carry);
        
        return res.reverse().toString();
    }
}
