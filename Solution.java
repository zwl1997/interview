package suanfa;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        String str = new StringBuilder(x+"").reverse().toString();
        return str.equals(x+"");
    }
}
