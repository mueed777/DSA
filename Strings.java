// Strings

public class Strings {
    public static void main(String args) {

    }

    /*
     * String Palindrome
     * time : O(n)
     * space: O(1)
     */
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char currStart = s.charAt(start);
            char currEnd = s.charAt(end);

            if (!Character.isLetterOrDigit(currStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(currStart) != Character.toLowerCase(currEnd)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    /*
     * create sub string
     * time : O(n)
     * space: O(1)
     */
    public static String createSubString(String str, int indexA, int indexB) {
        String subStr = "";
        for (int i = indexA; i <= indexB; i++) {
            subStr = subStr + str.charAt(i);
        }
        return subStr;
    }

    /*
     * print largest string
     * time :
     * space:
     */
    public static String largestString(String str[]) {
        int length = str.length;
        String largestString = str[0];
        for (int i = 1; i < length; i++) {
            if (largestString.compareTo(str[i]) < 0) {
                largestString = str[i];
            }
        }
        return largestString;
    }

    /*
     * convert letters to uppsercase
     * a given string, convert each the first letter of each word to uppercase
     * time :
     * space:
     */
    public static String uppserCased(String s) {
        StringBuilder stringBuilder = new StringBuilder("");
        char ch = Character.toUpperCase(s.charAt(0));
        stringBuilder.append(ch);

        int length = s.length();
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ' ' && i < length - 1) {
                stringBuilder.append(s.charAt(i));
                i++;
                stringBuilder.append(Character.toUpperCase(s.charAt(i)));
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    /*
     * string compression
     * input : aaabbcccdde
     * output: a3b2c3d2e1
     * time :
     * space :
     */
    public static String stringCompression(String s) {
        StringBuilder sb = new StringBuilder("");
        int length = s.length();
        for (int i = 0; i < length; i++) {
            Integer count = 1;
            while (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(s.charAt(i));
            sb.append(count.toString());
        }
        return sb.toString();
    }
}
