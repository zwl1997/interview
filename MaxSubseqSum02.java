package suanfa;

public class MaxSubseqSum02 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,-10,10,20,30,-40,6,7};

        int maxNum = 0;
        int thisNum = 0;

        for (int i = 0; i < arr.length; i++) {
            thisNum = 0;
            for (int j = i; j < arr.length; j++) {
                thisNum += arr[j];
                if(thisNum > maxNum){
                    maxNum = thisNum;
                }
            }
        }
        System.out.println(maxNum);
    }
}
