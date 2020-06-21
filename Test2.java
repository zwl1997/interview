package suanfa;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        getNumber(100);
    }

    public static void getNumber(int n) {
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if (numberIsPrime(i)) {
                result.add(i);
            }
        }

        for (int i = 0; i < result.size()-1; i++) {
            int var = result.get(i+1) - result.get(i);
            if(var == 2){
                count++;
                System.out.print(result.get(i)+" ");
                System.out.println(result.get(i+1));
            }
        }
        System.out.println(count);
    }

    private static boolean numberIsPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
