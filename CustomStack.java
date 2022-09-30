public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 5;
    int ptr = -1;

    public CustomStack(int size){
        this.data = new int[size];
    }

    public CustomStack(){
        this.data = new int[DEFAULT_SIZE];
    }

    

    public boolean push(int item){
        if(isFull()){
            System.out.println("it's full!!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }


    public int pop(){
        if(isEmpty()){
            System.out.println("cannot be popped, no elements");
            return -1;
        }
       
        return data[ptr--];
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    public boolean isFull(){
        return ptr == data.length - 1;
    }
}