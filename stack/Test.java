package suanfa.stack;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        Stack stack;
//        stack.peek();

        myStack.push("+");
        myStack.push("2");
        myStack.push("3");
        String push = myStack.push("4");
        String pop1 = myStack.pop();
//        String pop2 = myStack.pop();

        System.out.println(pop1);
//        System.out.println(pop2);

        myStack.print();
    }
}
