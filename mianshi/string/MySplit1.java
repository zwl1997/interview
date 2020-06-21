package suanfa.mianshi.string;

public class MySplit1 {
    public static void main(String[] args) {
        String str = "zwl&&male&&123aaaa&&www&&jijaaaabbbb";
        MyStr myStr = new MyStr();
        myStr.setStr(str);
        MyStr result = doSplit(myStr);
        for (String s : result.getList()) {
            System.out.println(s);
        }
    }

    private static MyStr doSplit(MyStr myStr) {
        while (myStr.getStr().length() > 0){
            substract("&&",myStr);
        }
        return myStr;
    }

    private static MyStr substract(String s,MyStr myStr) {
        int i = myStr.getStr().indexOf(s);
        if(i > 0){
            myStr.getList().add(myStr.getStr().substring(0, i));
            myStr.setStr(myStr.getStr().substring(i + 2,myStr.getStr().length()));
        }else{
            myStr.getList().add(myStr.getStr());
            myStr.setStr("");
        }
        return myStr;
    }
}
