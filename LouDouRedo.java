package suanfa;

public class LouDouRedo {
    public static void main(String[] args) {
        A a = new A(19,"*");
        a.getLength();
        a.printLouDou();
        int left = a.getLeft();
        System.out.println("余数为："+left);
    }
}

class A{
    private int levelLength = 0;
    private int left = 0;
    private int sum = 1;
    private int n;
    private final int MAX = 10000;
    private String str;

    public A(int n, String str){
        this.n = n;
        this.str = str;
    }

    public void getLength(){
        for (int i = 2; i < MAX; i++) {
            sum += (2 * i - 1) * 2;
            levelLength = 2 * i - 1;
            if(sum > n){
                sum -= (2 * i - 1) * 2;
                left = n - sum;
                levelLength -= 2;
                break;
            }
        }
    }

    public void printLouDou(){
        String space = "";
        for (int i = levelLength; i > 0; i=i-2) {
            for (int j = 0; j < i ; j++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.print(space);
            space += " ";
        }

        space = space.substring(1);
        for (int i = 3; i <= levelLength; i=i+2) {
            space = space.substring(1);
            System.out.print(space);
            for (int j = 0; j < i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public int getLeft() {
        return left;
    }
}
