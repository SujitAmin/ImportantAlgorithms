import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String text = "ABCABAABCABAC";
        String pattern = "BAC";
        System.out.println(KMP(text, pattern));
    }

    public static boolean KMP(String text, String pattern) {
        int countPattern = pattern.length();
        int countText = text.length();

        int[] lps = new int[countPattern];
        int j = 0;
        int i = 0;
        computeLPSS(pattern, lps ,countPattern);

        while (i < countText) {
            if(pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }

            if(j == countPattern) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
                return true;
            }
            else if (i < countText && pattern.charAt(j) != text.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway.
                if(j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return false;
    }

    private static void computeLPSS(String pattern, int[] lps, int countPattern) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while(i < countPattern) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
