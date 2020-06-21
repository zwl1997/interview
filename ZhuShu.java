package suanfa;

public class ZhuShu {
    public static void main(String[] args) {
        int j;
        for (int i = 2; i <= 100; i++) {
            j = 2;
            while (i % j != 0) {
                j++;
                if (j == i) {
                    System.out.println(i);
                }
            }
        }
    }
}
