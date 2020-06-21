package suanfa;

class DemoHash {
    public static void main(String[] args) {
        MyHash myHash = new MyHash(100);
        myHash.put(10001,0);
        myHash.put(1001,1);
        myHash.put(33,2);
        myHash.put(555,3);
        int value = myHash.get(33);
        int value1 = myHash.get(555);
        System.out.println(value);
        System.out.println(value1);

        MyLinkedList[] list = myHash.arr;
        MyLinkedList p;
        for (int i = 0; i < list.length; i++) {
            p = list[i];
            while (p != null){
                System.out.println("哈希索引(%100) "+i+"--"+"Key:"+p.MyKey+" Value:"+p.MyValue);
                p = p.Next;
            }
        }
    }
}

public class MyHash {
    private int max;
    MyLinkedList[] arr;

    public MyHash(int max) {
        this.max = max;
        this.arr = new MyLinkedList[max];
    }

    public void put(int key, int value) {
        int num = key % max;
        if(arr[num] == null){
            arr[num] = new MyLinkedList(key,value,null);
        }else{
            MyLinkedList p = arr[num];
            while (p.Next != null){
                p = p.Next;
            }
            p.Next = new MyLinkedList(key,value,null);
        }
    }

    public int get(int key) {
        int num = key % max;
        MyLinkedList p = arr[num];
        while (p != null){
            if(p.MyKey == key){
                return p.MyValue;
            }
            p = p.Next;
        }
        return -1;
    }
}
class MyLinkedList{
    int MyValue;
    int MyKey;
    MyLinkedList Next;

    public MyLinkedList(int myKey,int myValue, MyLinkedList next) {
        MyKey = myKey;
        MyValue = myValue;
        Next = next;
    }
}
