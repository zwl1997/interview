package suanfa;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        final int MaxSize =100000;
        List<Integer> list = new ArrayList<>();
        for (int i = MaxSize; i > 0; i--) {
            list.add(i);
        }

        long start = System.currentTimeMillis();
        myMethod1(3,list);
        long end = System.currentTimeMillis();
        System.out.println("自定义Map算法1耗时:"+(end-start));

        long start1 = System.currentTimeMillis();
        method1(3,list);
        long end1 = System.currentTimeMillis();
        System.out.println("算法1耗时:"+(end1-start1));

//        method2(199999,list);
        long end2 = System.currentTimeMillis();
//        System.out.println("算法2耗时:"+(end2-end1));

        list.sort((o1, o2) -> o1 - o2);
        method3(199999,list);
        long end3 = System.currentTimeMillis();
        System.out.println("算法3耗时:"+(end3-end2));
    }

    private static void method3(int addNum, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        int count = 0;
        while (start <= end){
            count = list.get(end) + list.get(start);
//            System.out.print(list.get(start)+"-");
//            System.out.println(list.get(end));
            if(count == addNum){
                System.out.print(start+" ");
                System.out.println(end);
                break;
            }else if(count > addNum){
                end--;
            }else {     //else不能省略
                start++;
            }
/*
            if(a> 0 ) {
                return a;
            }else if(a < 0){
                return b;
            }
            return c;
*/
        }
    }

    private static void method2(int addNum, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(i)+list.get(j) == addNum){
                    System.out.println("算法2:"+i+" "+j);
                    break;
                }
            }
        }
    }

    private static void method1(int addNum, List<Integer> list) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count = Math.abs(addNum - list.get(i));
            if(map.containsKey(count)){
                Integer value = map.get(count);
                System.out.print("算法1:"+value+" ");
                System.out.println(i);
                break;
            }
            map.put(list.get(i),i);
        }
    }

    private static void myMethod1(int addNum, List<Integer> list) {
        MyHash map = new MyHash(10000);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count = Math.abs(addNum - list.get(i));
            if(map.get(count) != -1){
                Integer value = map.get(count);
                System.out.print("自定义Map算法1:"+value+" ");
                System.out.println(i);
                break;
            }
            map.put(list.get(i),i);
        }
    }
}
