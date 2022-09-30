import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

      Queue<Integer> q1 = new LinkedList<>();
      Queue<Integer> q2 = new LinkedList<>();
      Queue<Integer> temp = new LinkedList<>();
      public boolean push(int item){
           q2.add(item);
           while(!q1.isEmpty()){
            q2.add(q1.poll());
           }

            temp = q1;
           q1 = q2;
           q2 = temp;

           return true;
      }

      public int pop(){
        return q1.poll();
      }


      public void display(){
        Iterator itr=q1.iterator();  
            while(itr.hasNext()){  
                System.out.println(itr.next());  
            }  
      }
}