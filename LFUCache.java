import java.util.*;

class LFUCache {
    class Node{
        Node prev,next;
        int key,value;
        int frequency;
        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }
    
    class DoubleLinkedList{
        Node head;
        Node tail;
        int listSize;
        
        public DoubleLinkedList(){
             this.listSize = 0;
             this.head = new Node(0,0);
             this.tail = new Node(0,0);
             head.next = tail;
             tail.prev = head;
        }
        
        public void addNode(Node node){
            node.next = head.next;
            node.prev = head;
            head.next = node;
            head.next.prev = node;
            
           
            listSize++;
        }
        
        public void removeNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            listSize--;
        }
    }
    
    int capacity;
    int currSize; //cache current size
    int minFreq;
    Map<Integer,Node> cache;
    Map<Integer,DoubleLinkedList> freqList;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqList = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
     
            updateNode(node);
            return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            updateNode(node);
        }else{
            Node node = new Node(key,value);
            if(currSize >= capacity){
                DoubleLinkedList minList = freqList.get(minFreq);
                cache.remove(minList.tail.prev.key);
                minList.removeNode(minList.tail.prev);
                currSize--;
            }

            minFreq = 1;
            currSize++;
            DoubleLinkedList currList = freqList.getOrDefault(1,new DoubleLinkedList());
            currList.addNode(node);
            freqList.put(1,currList);
            cache.put(key,node);
        }
    }
    
    public void updateNode(Node node){
        int currFreq = node.frequency;
        DoubleLinkedList currList = freqList.get(currFreq);
        currList.removeNode(node);
        
        if(currFreq == minFreq && currList.listSize == 0){
            minFreq++;
        }
        node.frequency++;
        DoubleLinkedList newList = freqList.getOrDefault(node.frequency,new DoubleLinkedList());
        newList.addNode(node);
        freqList.put(node.frequency,newList);
        
    }
}