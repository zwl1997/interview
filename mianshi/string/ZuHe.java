package suanfa.mianshi.string;

public class ZuHe {
    public static void main(String[] args) {
        String[] strings = new String[]{"zwl","123","yyy","xxx"};
        StringBuffer str = compose(strings,"&&");
        System.out.println(str);
    }

    private static StringBuffer compose(String[] strings,String n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            if(i == strings.length - 1){
                sb.append(strings[i]);
            }else{
                sb.append(strings[i]).append(n);
            }
        }
        return sb;
    }
}
