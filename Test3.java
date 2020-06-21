package suanfa;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        move2right(6, 2, arr);
    }

    private static void move2right(int length, int moveNum, int[] arr) {
        int count = 0;
        for (int i = arr.length - moveNum; i < arr.length; i++) {
            for (int j = i; j > count; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
            count++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
