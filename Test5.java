package suanfa;

import java.util.HashMap;
import java.util.Map;

public class Test5 {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(99997,2);
        map.put(2,3);

        System.out.println(map.containsKey(-99997));
        if(map.containsKey(1)){

            System.out.println(map.get(1));
        }

    }
}
