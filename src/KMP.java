
public class KMP{
    // Function to implement KMP algorithm
    public static boolean KMP(String X, String Y) {
        // Base Case 1: Y is null or empty
        if (Y == null || Y.length() == 0) {
            System.out.println("Pattern occurs with shift 0");
            return true;
        }

        // Base Case 2: X is null or X's length is less than that of Y's
        if (X == null || Y.length() > X.length()) {
            //System.out.println("Pattern not found");
            return false;
        }

        char[] chars = Y.toCharArray();

        // next[i] stores the index of next best partial match
        int[] next = new int[Y.length() + 1];
        next = computeLPS(chars, next, Y.length());

        for (int i = 0, j = 0; i < X.length(); i++) {
            if (j < Y.length() && X.charAt(i) == Y.charAt(j)) {
                j++;
                if (j == Y.length()) {
                    //System.out.println("Pattern occurs with shift " + (i - j + 1));
                    return true;
                }
            }
            else if (j > 0) {
                j = next[j];
                i--;    // since i will be incremented in next iteration
            }
        }
        return false;
    }

    static int[] computeLPS(char[] chars, int[] next , int length){
        for (int i = 1; i < length; i++)  {
            int j = next[i + 1];
            while (j > 0 && chars[j] != chars[i])
                j = next[j];
            if (j > 0 || chars[j] == chars[i])
                next[i + 1] = j + 1;
        }
        return next;
    }

    // Program to implement KMP Algorithm in Java
    public static void main(String[] args) {
        String text = "ABCABAABCABAC";
        String pattern = "BAC";//"CAB";

        System.out.println(KMP(text, pattern));;
    }
}

