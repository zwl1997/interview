package suanfa;

import java.util.ArrayList;
import java.util.List;

public class Digui {
    public static void print1(int n){
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void print(int n){
        if(n > 0){
            System.out.println("before:"+n);
            print(n-2);
            System.out.println("after:"+n);
        }
        return;
    }

    public static String space = "";
    public static void print4(int n){
        if(n > 0){
            System.out.print(space);
            space+=" ";
            printline(n);
            print4(n-2);
            if(n == 1){
                space = space.substring(1);
                return;
            }
            space = space.substring(1);
            System.out.print(space);
            printline(n);
        }
        return;
    }

    private static void printline(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(10);
//        print1(1000000);
//        print2(7);
    }
}


