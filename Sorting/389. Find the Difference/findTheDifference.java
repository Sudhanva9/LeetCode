// OWN

class Solution {
    public char findTheDifference(String s, String t) {
        char[] tString = t.toCharArray();
        Arrays.sort(tString);
        String sT = new String(tString);

        char[] sString = s.toCharArray();
        Arrays.sort(sString);
        String sS = new String(sString);

        char res = sT.charAt(sT.length() - 1);
        int p = 0, q = 0;

        while (p < sS.length() && q < sT.length()) {
            if (sS.charAt(p) != sT.charAt(q)) {
                res = sT.charAt(q);
                break;
            } else {
                p += 1;
                q += 1;
            }
        }

        return res;
    }
}

// WITHOUT EXTRA CONVERSION

class Solution {
    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return tArr[i];
            }
        }

        // If all characters matched, the extra character is at the end
        return tArr[tArr.length - 1];
    }
}
