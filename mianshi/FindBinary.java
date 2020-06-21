package suanfa.mianshi;

public class FindBinary {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i;
        }
        arr[857] = 5;

        int num = find(arr);
        System.out.println(num);
    }

    private static int find(int[] arr) {
        int middle = arr.length / 2;
        int num = 0;
        for (int i = 0; i < middle; i++) {
            for (int j = arr.length - 1; j >= middle; j--) {
                if(arr[i] == arr[j]){
                    num = arr[i];
                }
            }
        }
        return num;
    }
}
