package StringAlgorithms;

// Following program is a Java implementation
// of Rabin Karp Algorithm given in the CLRS book

public class RabinKarp {

    static int search(String pat, String txt) {
        // d is the number of characters in the input alphabet
        int twentySix = 26;//256;
        int prime = (int)Math.pow(10, 9) + 7;
        int patternLength = pat.length();
        int textLength = txt.length();
        int i, j;
        int hashValueOfPattern = 0; // hash value for pattern
        int hashValueOfText = 0; // hash value for txt

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < patternLength; i++) {
            //abc
            // 26^ 2 * 1 + 26 ^1 * 2 + 3 = 731
            hashValueOfPattern = (twentySix * hashValueOfPattern + getCharacterValue(pat.charAt(i)) ) % prime;
            hashValueOfText = (twentySix * hashValueOfText + getCharacterValue(txt.charAt(i))) % prime;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= textLength - patternLength; i++) {
            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if (hashValueOfPattern == hashValueOfText) {
                /* Check for characters one by one */
                for (j = 0; j < patternLength; j++) {
                    if ( getCharacterValue(txt.charAt(i + j)) != getCharacterValue(pat.charAt(j)))
                        break;
                }
                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == patternLength)
                    return i;
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < textLength - patternLength) {
                int previousCharacter = getCharacterValue(txt.charAt(i));
                int dMinus1 = (int)(Math.pow(twentySix, patternLength - 1) % prime);
                int nextCharacter = getCharacterValue(txt.charAt(i + patternLength));
                // 26 *(731 - 26 ^ 2) + 4
                hashValueOfText = (twentySix * (hashValueOfText - previousCharacter * dMinus1) + nextCharacter) % prime;
                // We might get negative value of t, converting it
                // to positive
                if (hashValueOfText < 0)
                    hashValueOfText = (hashValueOfText + prime);
            }
        }
        return -1;
    }

    private static int getCharacterValue(char character) {
        return (character - 'a') + 1;
    }

    public static void main(String[] args) {
        String txt = "abcde";
        String pat = "bcd";
        System.out.println(search(pat, txt));;
    }
}