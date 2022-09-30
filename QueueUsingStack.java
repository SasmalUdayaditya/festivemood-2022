import java.util.*;
public class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void push(int item){
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        s1.push(item);
        while(!s2.empty()){
            s1.push(s2.pop());
        }

    }

    public int pop(){
        return s1.pop();
    }

    public int front(){
        return s1.peek();
    }

    public void display(){
        for(int i=0;i<s1.size();i++){
            System.out.print(s1.get(i) + " -> ");
        }
    }

}