package suanfa.mianshi;

public class MaxZhiShu1 {
    public static void main(String[] args) {
        int n = 100;
        result(n);
    }

    private static void result(int n) {
        int maxPrame = 0;
        for (int i = 2; i < n; i++) {
            if(isPrame(i)){
                maxPrame = i;
            }
        }
        System.out.println(maxPrame);
    }

    private static boolean isPrame(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
