package suanfa;

public class MaxSubseqSum03 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,-10,10,20,30,-40,6,7};
        int thisSum = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if(thisSum > maxSum){
                maxSum = thisSum;
            }else if(thisSum < 0){
                thisSum = 0;
            }
        }
        System.out.println(maxSum);
    }
}
