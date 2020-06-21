package suanfa;

public class ErFenSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        int result = binarySearch(arr,2);
        System.out.println(result);
    }

    private static int binarySearch(int[] arr,int searchNum) {
        int left = 1;
        int right = arr.length;
        int middle;
        while (left <= right){
            middle = (left + right) / 2;
            if(middle < searchNum){
                left = middle + 1;
            }else if(middle > searchNum){
                right = middle - 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
