package suanfa;

public class MaxSubseqSum01 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,-10,10,20,30,-40,6,7};

        int maxNum = 0;
        int thisNum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                thisNum = 0;
                for (int k = i; k <= j; k++) {
                    thisNum += arr[k];
                    if(thisNum > maxNum){
                        maxNum = thisNum;
                    }
                }
            }
        }
        System.out.println(maxNum);
    }
}
