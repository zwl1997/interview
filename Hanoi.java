package suanfa;

public class Hanoi {
    public static void main(String[] args) {
        hanoi(3,"x","y","z");
    }

    public static void hanoi(int n,String x,String y,String z){
        if(n == 1){
            move(x,1,z);
//            return;
        }else{
            System.out.println((n-1) + ":"+ x +","+ z+","+y);
            hanoi(n-1,x,z,y); //1:x,y,z
            move(x,n,z);
            System.out.println((n-1) + ":"+ y +","+ x+","+z);
            hanoi(n-1,y,x,z); //1:z,x,y
        }
    }

    private static void move(String x,int i,String z) {
        System.out.println(i + "号圆盘" + ":" + x + "轴-->" + z + "轴");
    }
}
