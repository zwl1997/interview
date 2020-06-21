package suanfa;

class Org{
    private String str;
    private int sum = 1;
    private int levelCount = 0;
    private int remain = 0;
    private int n;
    final int MAX = 100000;

    public Org(int n, String str){
        this.n = n;
        this.str = str;
    }

    public int handle(){
        for (int i = 2; i <= MAX; i++) {
//            System.out.println(i);
            sum += (2*i-1)*2;
            levelCount = 2*i-1;
            if(sum == n){
                break;
            }
            if(sum > n){
                sum -= (2*i-1)*2;
                remain = n-sum;
                levelCount = levelCount -2;
                break;
            }
        }
        return levelCount;
    }

    public static void print(int n){
        String space = "";
        for (int i = n; i >= 1; i=i-2) {
            System.out.print(space);
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
            space += " ";
        }
        space = space.substring(1);
        for (int i = 3; i <= n; i=i+2) {
            space = space.substring(1);
            System.out.print(space);
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public int getRemain() {
        return remain;
    }
}

public class LouDou {
    public static void main(String[] args) {
        Org org = new Org(34,"*");
        int count = org.handle();
        int remain = org.getRemain();
        org.print(count);
        System.out.println("余数:"+remain);
    }
}


