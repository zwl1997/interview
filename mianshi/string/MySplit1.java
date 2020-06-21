package suanfa.mianshi.string;

public class MySplit1 {
    public static void main(String[] args) {
        String str = "zwl&&male&&123aaaa&&www&&jijaaaabbbb";
        doSplit(str);
        for (String s : MyStr.a) {
            System.out.println(s);
        }
    }

    private static void doSplit(String str) {
        MyStr.b = str;
        while (MyStr.b.length() > 0){
            substract("&&");
        }
    }

    private static void substract(String s) {
        int i = MyStr.b.indexOf(s);
        if(i > 0){
            MyStr.a.add(MyStr.b.substring(0, i));
            MyStr.b = MyStr.b.substring(i + 2,MyStr.b.length());
        }else{
            MyStr.a.add(MyStr.b);
            MyStr.b = "";
        }
    }
}
