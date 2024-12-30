import java.util.Scanner;

public class PracticeStrings {
    public static void main(String args[]) {
        String str = "ApnaCollege".replace("l", "");
        System.out.println(str);

        // ApnaCoege

    }

    /*
     * Question 1
     * ⚠️⚠️⚠️⚠️ - not solved properly (maybe)
     */
    public static int lowerCaseOccured(String s) {
        int count = 0;
        int length = s.length();
        for(int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if(s.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}
