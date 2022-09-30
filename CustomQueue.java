public class CustomQueue {
    protected int[] data;
    public static final int DEFAULT_SIZE = 5;

    public CustomQueue(int size){
        data = new int[size];
    }
    public CustomQueue(){
        data = new int[DEFAULT_SIZE];
    }

    int end = 0;

    public boolean isEmpty(){
        return end == 0;
    }

    public boolean isFull(){
        return end == data.length;
    }

    public int peek(){
        return data[0];
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        return true;
    }

    public boolean remove(){
        if(isEmpty()){
            return false;
        }
        for(int i=1;i<data.length;i++){
            data[i-1] = data[i];
        }
        return true;
    }
    
    public void display(){
        for(int i=0;i<end;i++){
            System.out.print(data[i] + "  <-  ");
        }

        System.out.println("END");
    }
}