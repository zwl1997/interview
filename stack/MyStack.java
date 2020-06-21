package suanfa.stack;

public class MyStack {
    String[] arr = new String[100];
    private int top = -1;

    public boolean empty(){
        return top == -1;
    }

    public String push(String member){
        arr[++top]=member;
        return member;
    }

    public String pop(){
        if(top == -1){
            return "";
        }
        return arr[top--];
    }

    public String peek(){
        if(top == -1){
            return "";
        }
        return arr[top];
    }

    public void print(){
        for (int i = 0; i <= top; i++) {
            if(!arr[i].equals("")){
                System.out.print(arr[i]);
            }
        }
    }
}
