package suanfa.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator1 {
    public static void main(String[] args) {
        String str = "33*52/3+2*3-1";
        List<String> list = split(str);

        for (String l : list) {
            System.out.print(l + " ");
        }
        System.out.println();

        Stack<String> stack = new Stack<>();

        List<String> result = handlePrefix(stack, list);

        for (int i = 0; i < result.size(); i++) {
            if (!result.get(i).equals("")) {
                System.out.print(result.get(i) + " ");
            }
        }
    }

    //中缀转后缀
    private static List<String> handlePrefix(Stack<String> stack, List<String> arr) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals("+") || arr.get(i).equals("-")) {
                if (stack.peek().equals("*") || stack.peek().equals("/")) {
                    while (!stack.empty()) {
                        result.add(stack.pop() + "");
                    }
                }
                stack.push(arr.get(i));
                continue;
            }
            if (arr.get(i).equals("*") || arr.get(i).equals("/")) {
                if (stack.peek().equals("*") || stack.peek().equals("/")) {
                    while (!stack.empty()) {
                        result.add(stack.pop() + "");
                    }
                }
                stack.push(arr.get(i));
                continue;
            }
            System.out.println(result);
            try {
                Integer.parseInt(arr.get(i));
                result.add(arr.get(i));
            } catch (NumberFormatException e) {
//                e.printStackTrace();
                System.out.println(e);
            }
        }

        while (!stack.empty()) {
            result.add(stack.pop());
        }

        System.out.println(result);

        return result;
    }

    public static List<String> split(String str) {
        List<String> list = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*' || str.charAt(i) == '/'
                    || str.charAt(i) == '-' || str.charAt(i) == '+') {
                list.add(str.substring(num, i));
                list.add(str.charAt(i) + "");
                num = i + 1;
            }
        }
        list.add(str.substring(num));
        return list;
    }
}
