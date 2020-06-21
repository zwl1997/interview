package suanfa.mianshi.string;

import java.util.ArrayList;
import java.util.List;

public class MySplit {
    public static void main(String[] args) {
        String str = "zwl&&male&&123aaaa&&www&&jijaaaaa";
//        String str1 = "0123";
//        String substring = str1.substring(4);
//        System.out.println(substring);
//        int i = str.indexOf("&");   //-1
//        System.out.println(i);
        List<String> list = doSplit(str,'&',2);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static List<String> doSplit(String str,char tag,int len) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while (true){
            str = str.substring(i, str.length());
            i = str.indexOf(tag);
            if(i == -1){
                list.add(str);
                break;
            }else {
                String s = str.substring(0, i);
                i = i + len;
                list.add(s);
            }
        }
        return list;
    }
}
