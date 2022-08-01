package projecteuler.library;

public class StringUtil {
    public static boolean isPalindromic(String s) {
        if(s.isBlank() || s.length() == 1) return true;

        int size = s.length();

        for(int i = 0; i < size; i++) {
            if(s.charAt(i) != s.charAt(size - 1 - i)) return false;
        }

        return true;
    }
}
