package suanfa;

public class FenZhi {
    public static void main(String[] args) {
//        int[] arr = new int[]{-10,5,2,-3,1,7,-8,3,1};
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int max = method(0, arr.length-1, arr);
        System.out.println(max);
    }

    private static int method(int left, int right, int[] arr) {
        int[] A = arr;
        int center = (right+left)/2;
        if(left==right){
            return A[left];
        }

        int MaxLeftSum = method(left,center,A);
        int MaxRightSum = method(center+1,right,A);
        System.out.print(MaxLeftSum+" ");
        System.out.print(MaxRightSum+" ");

        /*下面求跨越边界的子列最大和*/
        int MaxLeftBorderSum = 0;
        int LeftBorderSum = 0;
        for(int i = center;i>=left;i--){
            LeftBorderSum += A[i];
            if(LeftBorderSum > MaxLeftBorderSum){
                MaxLeftBorderSum = LeftBorderSum;
            }
        }

        int MaxRightBorderSum = 0;
        int RightBorderSum = 0;
        for(int i = center+1;i<=right;i++){
            RightBorderSum += A[i];
            if(RightBorderSum > MaxRightBorderSum){
                MaxRightBorderSum = RightBorderSum;
            }
        }
        System.out.println(MaxLeftBorderSum+MaxRightBorderSum);
        return maxOf(MaxLeftBorderSum+MaxRightBorderSum,MaxLeftSum,MaxRightSum);
    }

    private static int maxOf(int a, int b, int c) {
        if(a>b && a>c){
            return a;
        }else if(b>a && b>c){
            return b;
        }
        return c;
    }
}
