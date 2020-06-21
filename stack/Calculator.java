package suanfa.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
//        String str = "3*5/3+2*3-1";
        String str = "3 * ( (1 + 2) * (3 + 4) ) * 2 + 4";
        List<String> list = split(str);

        System.out.print("中缀表达式:");
        for (String l : list) {
            System.out.print(l + " ");
        }
        System.out.println();

        MyStack stack = new MyStack();

        List<String> result = handlePrefix1(stack, list);

        System.out.print("后缀表达式:");
        for (int i = 0; i < result.size(); i++) {
            if (!result.get(i).equals("")) {
                System.out.print(result.get(i) + " ");
            }
        }
        System.out.println();

        int num = countResult(result);
        System.out.println("结果是:"+num);
    }

    //通过后缀表达式计算结果
    private static int countResult(List<String> result) {
        Stack<Integer> values = new Stack<>();
        int num = 0;
        String str;
        for (int i = 0; i < result.size(); i++) {
            str = result.get(i);
            if (str.equals("*") || str.equals("-")
                    || str.equals("+") || str.equals("/")) {
                num = calculate(str, values.pop(), values.pop());
                values.push(num);
            } else {
                try {
                    values.push(Integer.parseInt(result.get(i)));
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            }
        }
        num = values.pop();
        return num;
    }

    //对相邻两数做运算求结果
    private static int calculate(String str, Integer a, Integer b) {
        int result = 0;
        if (str.equals("+")) {
            result = b + a;
        }
        if (str.equals("-")) {
            result = b - a;
        }
        if (str.equals("*")) {
            result = b * a;
        }
        if (str.equals("/")) {
            result = b / a;
        }
        return result;
    }

    //中缀转后缀
    private static List<String> handlePrefix(MyStack stack, List<String> arr) {
        List<String> result = new ArrayList<>();

        String str;
        for (int i = 0; i < arr.size(); i++) {
            str = arr.get(i);
            if(str.equals("(")){
                stack.push(str);
                continue;
            }
            if (str.equals("+") || str.equals("-")) {
                while (!stack.empty() && !stack.peek().equals("(")) {
                    result.add(stack.pop() + "");
                }
                stack.push(arr.get(i));
                continue;
            }
            if (str.equals("*") || str.equals("/")) {
                if(stack.peek().equals("*") || stack.peek().equals("/")) {
                    result.add(stack.pop() + "");
                }
                stack.push(str);
                continue;
            }
            if(str.equals(")")){
                while(!stack.empty() && !stack.peek().equals("(")){
                    result.add(stack.pop());
                }
                stack.pop();
                continue;
            }
            //字符串为数字时
            try {
                Integer.parseInt(str);
                result.add(str);
                System.out.println(Integer.parseInt(str));
            } catch (NumberFormatException e) {
//                e.printStackTrace();
                System.out.println(e);
            }
        }

        while (!stack.peek().equals("")) {
            result.add(stack.pop());
        }

        return result;
    }


    //中缀转后缀
    private static List<String> handlePrefix1(MyStack stack, List<String> arr) {
        List<String> result = new ArrayList<>();

        String str;
        for (int i = 0; i < arr.size(); i++) {
            str = arr.get(i);

            switch(str){
                case "(":
                    stack.push(str);
                    break;
                case "+":
                case "-":
                    while (!stack.empty() && !stack.peek().equals("(")) {
                        result.add(stack.pop() + "");
                    }
                    stack.push(str);
                    break;
                case "*":
                case "/":
                    if(stack.peek().equals("*") || stack.peek().equals("/")) {
                        result.add(stack.pop() + "");
                    }
                    stack.push(str);
                    break;
                case ")":
                    while(!stack.empty() && !stack.peek().equals("(")){
                        result.add(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    //字符串为数字时
                    try {
                        Integer.parseInt(str);
                        result.add(str);
                        System.out.println(Integer.parseInt(str));
                    } catch (NumberFormatException e) {
//                e.printStackTrace();
                        System.out.println(e);
                    }
                    break;
            }

        }
        while (!stack.peek().equals("")) {
            result.add(stack.pop());
        }

        return result;
    }

    //对字符串做分割处理，得到一个List，其中存了数字和符号所对应的字符串
    public static List<String> split(String prefix) {
        String str = prefix.replace(" ","");
        List<String> list = new ArrayList<>();

        //33 * ( 11 + 22 ) + 44
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            switch (ch){
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                case ')':
                    if(num == i){
                        list.add(ch+"");
                        num=i+1;
                        break;
                    }
                    list.add(str.substring(num,i));
                    list.add(ch+"");
                    num=i+1;
                    break;
                default:
                    break;
            }
        }
        list.add(str.substring(num,str.length()));

        for (String l : list) {
            System.out.print(l+"_");
        }
        return list;
    }
}
